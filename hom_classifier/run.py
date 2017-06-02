#!/usr/bin/env python
""" "higher" (Second Order) Mutant Classifier, Author: Alex Fout, Date:20160420"""

import sys
import subprocess
import os
from os import listdir, system
from os.path import isdir, isfile, join
import random
import copy
from glob import glob
from multiprocessing import Pool


import logging
import argparse

''' ========================================================= '''
''' ====================== Mutant Class ===================== '''
''' ========================================================= '''

class hom_classifier:
    def __init__(self):
        pass

    #===================================================
    #===================== Make HOMs ===================
    #===================================================

    def create_soms_for_umut(self, umut, cm):
        ''' creates second order mutants by combining the unclassified mutant with each mutant in cm '''
        soms = []
        for m in cm:
            som = mutant.combine_mutants(umut, m)
            soms.append(som)
        self.soms = soms
        logging.info("created {} soms for {} from cm set".format(len(soms), m.c_name + ":" + m.name))
        return soms

    def create_hom_tree(self, foms):
        ''' creates a mutation tree by successively combining pairs of mutants until only one remains '''
        # if there is an odd number of mutants, duplicate the first one at the end
        layer_mutants = foms
        homs = copy.deepcopy(foms)
        while(len(layer_mutants)!=1):
            # make sure there is an even number in this layer
            if len(layer_mutants)%2 != 0:
                layer_mutants.append(copy.deepcopy(layer_mutants[0]))
            next_layer = []
            for i in xrange(len(layer_mutants)/2):
                next_layer.append(mutant.combine_mutants(layer_mutants[2*i], layer_mutants[2*i + 1]))
            homs.extend(next_layer)
            layer_mutants = next_layer
        logging.info("Generated {} homs in the mutation tree".format(len(homs)))
        for i in range(len(homs)):
            logging.debug(homs[i])
        i = 0
        for hom in homs:
            if len(hom.name) > 255:
                hom.name = "mutant " + str(i)
                i += 1
        return homs, homs[-1] # the last hom added is the root of the tree, right?

       
    def permute_list(self, lizt, seed):
        ''' permutes a list according to some seed'''
        random.seed(seed)
        random.shuffle(lizt)
        return lizt
        
    #===================================================
    #=================== Classifiers ===================
    #===================================================
    
    def classify_umuts_w_2ndOM_parallel(self, umuts, cms, killabledir, equivalentdir, scratchpath):
        ''' classifies all unclassified mutants using second order mutants '''
        logging.debug("Classifying with a second order classifier")
        p = Pool(7)
        num_killable = 0
        num_equivalent = 0
        ## compile and generate output for each cm
        for cm in cms:
            self.compile_mutant(cm)
            cm.output = self.run_mutant(cm, timeout=3)
        for umut in umuts:
            logging.debug("killing: " + str(umut))
            kill_fn_args = []
            for cm in cms:
                if cm.lines == umut.lines:
                    continue
                ## create 2om, copy to scratch dir and compile/run
                som = mutant.combine_mutants(umut, cm)
                som.path = join(scratchpath, som.name)
                self.write_mutant_source_to_files([som])
                self.compile_mutant(som)
                kill_fn_args.append((som, cm.output, 3)) #timeout = 3
            kill_results = p.map(self.kill, kill_fn_args)
            i = 0
            for result in kill_results: 
                if result == True:
                    num_killable += 1
                    putdir = killabledir
                    umut.classification = "killable"
                    logging.debug(str(umut) + " is possibly killable, based on cm:" + str(cms[i]))
                    logging.debug(str(cms[i]) + " lines: \n" + cms[i].get_affected_lines_string())
                    som = mutant.combine_mutants(umut, cms[i])
                    som.original_path = umut.original_path
                    som.original_code = umut.original_code
                    som.original_output = umut.original_output
                    logging.debug(str(som) + " lines: \n" + som.get_affected_lines_string())
                    break;
            else:
                # every test is equivalent, classify this as equivalent
                num_equivalent += 1
                putdir = equivalentdir
                umut.classification = "equivalent"
                logging.debug(str(umut) + " is possibly equivalent")
            # copy mutant dir to appropriate dir
            self.copy_dir(umut.path, putdir)
        logging.info("classified {} umuts, {} were possibly killable and {} were possibly equivalent".format(len(umuts), num_killable, num_equivalent))

    def classify_umuts_w_2ndOM(self, umuts, cms, killabledir, equivalentdir, scratchpath):
        ''' classifies all unclassified mutants using second order mutants '''
        logging.debug("Classifying with a second order classifier")
        num_killable = 0
        num_equivalent = 0
        for umut in umuts:
            for cm in cms:
                cm.run_if_needed()
                if cm.lines == umut.lines:
                    continue
                ## create 2om, copy to scratch dir and compile/run
                som = mutant.combine_mutants(umut, cm)
                som.path = join(scratchpath, som.name)
                mutant.write(som)
                # attempt to kill mutant
                if som.kill(3, cm.output):
                    num_killable += 1
                    putdir = killabledir
                    umut.classification = "killable"
                    logging.debug(str(umut) + " is possibly killable, based on cm:" + str(cm))
                    logging.debug(str(cm))
                    som.original_path = umut.original_path
                    som.original_code = umut.original_code
                    som.original_output = umut.original_output
                    logging.debug(str(som) + " lines: \n" + som.get_affected_lines_string())
                    break # break inner for loop
            else:
                # every test is equivalent, classify this as equivalent
                num_equivalent += 1
                putdir = equivalentdir
                umut.classification = "equivalent"
                logging.debug(str(umut) + " is possibly equivalent")
            # copy mutant dir to appropriate dir
            copy_dir(umut.path, putdir)
        logging.info("classified {} umuts, {} were possibly killable and {} were possibly equivalent".format(len(umuts), num_killable, num_equivalent))

    def classify_umuts_w_HOM(self, umuts, killabledir, equivalentdir, scratchpath):
        logging.debug("Classifying with a higher order classifier")
        original = mutant.load(join(this_path, "original"), join(this_path, "original/"))
        # create tree of mutant and write to file
        homs, root = self.create_hom_tree(umuts)
        mutant.set_base_path_all(homs, scratchpath)
        mutant.write_all(homs)
        
        # recursively classify all mutants in the tree
        self.recursive_classify(root, root)

        # copy to directory
        num_equivalent = 0
        num_killable = 0
        for umut in umuts:
            if umut.classification == "killable":
                num_killable += 1
                putdir = killabledir
                logging.debug(str(umut) + " is possibly killable")
            elif umut.classification == "equivalent":
                num_equivalent += 1
                putdir = equivalentdir
                logging.debug(str(umut) + " is possibly equivalent")
                logging.debug(umut.get_affected_lines_string(3))
            copy_dir(umut.path, putdir)
        logging.info("classified {} umuts, {} were possibly killable and {} were possibly equivalent".format(len(umuts), num_killable, num_equivalent))

    def recursive_classify(self, m, root):
        ''' helper method for the hom classifier ''' 
        if len(m.parents)==0:
            return
        # if both parents are already classified, do nothing 
        p1 = m.parents[0]
        p2 = m.parents[1]
        p1.run_if_needed()
        p2.run_if_needed()
        logging.debug("parent1: " + str(p1) + ": " + str(p1.output))
        logging.debug("parent2: " + str(p2) + ": " + str(p2.output))
        logging.debug("child: " + str(m) + ": " + str(m.output))
        self.recursive_classify(p1, root)
        self.recursive_classify(p2, root)
        # if both parents are already classified, do nothing
        if(p1.classification != "" and p1.classification != ""):
            logging.debug(str(p1) + " and " + str(p2) + " are already classified")
            return
        # if the output of both parents is different than the child, then both parents are possibly killable.
        # all unclassified ancestors of the parents are also possibly killable
        if(p1.output != m.output)and(p2.output != m.output):
            p1.classification = "killable"
            p2.classification = "killable"
            p1.set_unclassified_ancestors("killable")
            p2.set_unclassified_ancestors("killable")
            logging.debug(str(p1) + " and " + str(p2) + " output both differ from child")
        # if the output of both parents is the same as their child, then do not classify the parents yet,
        # unless the child is the last node, in which case the parents are possibly equivalent.
        # In such case, all unclassified ancestors of the parents are also possibly equivalent.
        elif(p1.output == m.output)and(p2.output == m.output):
            logging.debug(str(p1) + " and " + str(p2) + " output are both equal to child")
            if m == root:
                p1.classification = "equivalent"
                p2.classification = "equivalent"
                p1.set_unclassified_ancestors("equivalent")
                p2.set_unclassified_ancestors("equivalent")
        # if the output of one parent is the same as its child but the output of the other parent is different from its child,
        # then the former parent (and its ancestors) is possibly equivalent 
        # and the latter parent (and its ancestors) is possibly killable
        elif(p1.output != m.output):
            logging.debug(str(p1) + " output differs from child")
            p1.classification = "killable"
            p2.classification = "equivalent"
            p1.set_unclassified_ancestors("killable")
            p2.set_unclassified_ancestors("equivalent")
        else: # p2.output != m.output, reverse of last situation
            logging.debug(str(p2) + " output differs from child")
            p1.classification = "equivalent"
            p2.classification = "killable"
            p1.set_unclassified_ancestors("equivalent")
            p2.set_unclassified_ancestors("killable")

    def classifier_score(self, umuts, class_list_path):
        ''' calculates the classifier score based on classifier classes (umuts) and the ground truth (lists) '''
        equiv_list, killable_list = mutant.load_mutant_classifications(class_list_path)
        tk = 0 # true killable
        te = 0 # true equivalent
        fk = 0 # false killable
        fe = 0 # false equivalent
        for umut in umuts:
            if umut.classification == "equivalent":
                if umut.name in equiv_list:
                    te += 1.0
                elif umut.name in killable_list:
                    fe += 1.0
                else:
                    logging.error("mutant " + str(umut) + " not in classification file")
                    sys.exit()
            elif umut.classification == "killable":
                if umut.name in killable_list:
                    tk += 1.0
                elif umut.name in equiv_list:
                    fk += 1.0
                else:
                    logging.error("mutant " + str(umut) + " not in classification file")
                    sys.exit()
            else:
                logging.error("mutant " + str(umut) + " not classified")

        logging.debug("tk: " + str(tk))
        logging.debug("fk: " + str(fk))
        logging.debug("te: " + str(te))
        logging.debug("fe: " + str(fe))

        precision = tk/(tk+fk) if tk+fk!=0 else None
        recall =  tk/(tk+fe) if tk+fe!=0 else None
        accuracy =  (tk+te)/(tk+fk+te+fe) if tk+fk+te+tk!=0 else None
        f_2 = self.f_measure(precision, recall, 2)
        f_1 = self.f_measure(precision, recall, 1)
        f_0_5 = self.f_measure(precision, recall, 0.5)
        return  tk, fk, te, fe, precision, recall, accuracy, f_2, f_1, f_0_5

    def f_measure(self, precision, recall, beta):
        if precision == None or recall == None:
            return None
        return (1 + beta * beta) * (precision + recall) / (beta * beta * precision + recall)
            
            



''' ========================================================= '''
''' ====================== Mutant Class ===================== '''
''' ========================================================= '''

class mutant:
    #===========================================
    #=========== Make New Mutants ==============
    #===========================================
    def __init__(self, c_name="", name="", code="", path=""):
        self.c_name = c_name
        self.name = name
        self.code = code
        self.original_code = ""
        self.path = path
        self.original_path = ""
        self.lines = ""
        self.killed = False
        self.output = ""
        self.original_output= ""
        self.parents = []
        self.classification = ""
    
    @classmethod    
    def combine_mutants(self, m1, m2):
        ''' create a combined mutant from m1, m2 prefers variants in m1 over m2 if on same line'''
        l1 = frozenset(m1.lines)
        l2 = frozenset(m2.lines)
        
        # iterate through lines of mutants, assumes that lines not in l1 or l2 are identical in both mutants
        m1_code_lines = m1.code.splitlines()
        m2_code_lines = m2.code.splitlines()
        m3_code_lines = []
        for i in xrange(len(m1_code_lines)):
            # if change in m1 AND m2, then variant from m1 is taken
            if (i not in l1) and (i in l2):
                m3_code_lines.append(m2_code_lines[i])
            else:
                m3_code_lines.append(m1_code_lines[i])
        m3 = mutant(m1.c_name, m1.name + m2.name, "\n".join(m3_code_lines), "")
        m3.lines = list(l1|l2)
        m3.parents.extend((m1, m2))
        logging.debug("new mutant:" + str(m3.name))
        return m3
   
    #===========================================
    #============ Write to File ================
    #===========================================
    def write(self):
        # make dir if it doesn't exist
        if not os.path.exists(self.path):
            os.makedirs(self.path)

        # generate .mutant file contents
        out_string = ""
        out_string += "c_name:" + str(self.c_name) + "\n"
        out_string += "name:" + str(self.name) + "\n"
        out_string += "path:" + str(self.path) + "\n"
        out_string += "original_path:" + str(self.original_path) + "\n"
        out_string += "lines:" + str(self.lines) + "\n"
        out_string += "==BeginOutput==\n"
        out_string += str(self.output)
        out_string += "==EndOutput==\n"
        out_string += "==BeginOriginalOutput==\n"
        out_string += str(self.original_output)
        out_string += "==EndOriginalOutput==\n"
        # write .mutant file
        filepath = join(self.path, self.name + ".mutant")
        with open(filepath, 'w') as f:
            f.write(out_string)
        # write .java file
        write_string_to_file(self.code, join(self.path, self.c_name + ".java"))

        logging.debug("wrote {} to file".format(str(self)))

    @classmethod
    def write_all(self, mutants):
        logging.info("Writing Mutants to File")
        for mut in mutants:
            mutant.write(mut)
        logging.debug("wrote {} mutants to file".format(len(mutants)))

    #===========================================
    #============ Load from File ===============
    #===========================================
    @classmethod
    def load(self, path, original_path=""):
        '''loads a mutant in a folder from the .java and .mutant files'''
        # if .mutant file doesn't exist, then call other method to load from file
        filename = [f for f in listdir(path) if isfile(join(path, f)) and ".mutant" in f]
        if filename == []:
            return mutant.__load_new(path, original_path)

        # load from .mutant file
        #filename = filename[0].split(".mutant")[0]
        filename = filename[0]
        in_lines = ""    
        with open(join(path, filename)) as f:
            in_lines = f.readlines()
        m = mutant(); i=0
        m.c_name = in_lines[i][7:].replace("\n",""); i+=1
        m.name = in_lines[i][5:].replace("\n",""); i+=1
        m.path = in_lines[i][5:].replace("\n",""); i+=1
        m.original_path = in_lines[i][14:].replace("\n",""); i+=1
        m.lines= eval(in_lines[i][6:].replace("\n","")); i+=1
        # load code from .java file
        with open(join(path, m.c_name + ".java")) as f:
            m.code = f.read()
        # load original code from .java file
        with open(join(original_path, m.c_name + ".java")) as f:
            m.original_code = f.read()
        # load output
        outputstring = ""; i+=1
        while in_lines[i] != "==EndOutput==\n":
            outputstring += "\n" + in_lines[i]
            i+=1
        m.output = outputstring
        # load original output
        original_outputstring = ""; i+=2
        while in_lines[i] != "==EndOriginalOutput==\n":
            original_outputstring += "\n" + in_lines[i]
            i+=1
        m.original_output = original_outputstring

        logging.debug("loaded {} from file".format(str(m)))
        return m
    
    @classmethod
    def __load_new(self, path, original_path):
        ''' loads a mutant from a directory without using a .mutant file '''
        classname = [f for f in listdir(path) if isfile(join(path, f)) and ".java" in f]
        if classname == []:
            logging.error("Error: no java source file in " + path)
            sys.exit()
        classname = classname[0].split(".java")[0]
        m = mutant()
        m.c_name = classname
        m.name = path.split("/")[-1]
        m.path = path
        m.original_path = original_path
        with open(join(path, m.c_name + ".java")) as f:
            m.code = f.read()
        with open(join(original_path, m.c_name + ".java")) as f:
            m.original_code = f.read()
        m.determine_affected_lines()
        # do not return a mutant if number of lines does not match original file
        if m.lines == -1:
            logging.debug("skipped {} due to line mismatch".format(str(m)))
            return None
        logging.debug("loaded {} from file".format(str(m)))
        return m
    
    @classmethod
    def load_all(self, path, original_path):
        logging.info("Loading Mutants")
        mut_paths = [d for d in listdir(path) if isdir(join(path, d))]
        muts = []
        for mut_path in mut_paths:
            m = mutant.load(join(path, mut_path), original_path)
            if m is not None:
                muts.append(m)
        logging.info("Loaded {} Mutants".format(len(muts)))
        return muts
   
    @classmethod
    def load_mujava_foms(self, directory):
        ''' loads fom source files and constructs mutant objects  '''
        ''' directory should contain the "traditional_mutants" and "original" directories '''
        ## read each mutant and get it's name from the directory it's in
        foms = []
        tm_path = join(directory, "traditional_mutants")
        method_dirs = [d for d in listdir(tm_path) if isdir(join(tm_path, d))]
        for method_dir in method_dirs: 
            mut_dirs = [d for d in listdir(join(tm_path, method_dir)) if isdir(join(tm_path, method_dir, d))]
            for mut_dir in mut_dirs:
                # should only contain a single .java file
                names, codes = load_java_from_dir(join(tm_path, method_dir, mut_dir))
                original_path = join(directory, "original/")
                mut_path = join(tm_path, method_dir, mut_dir)
                m = mutant.load(mut_path, original_path)
                if m is not None:
                    m.name = m.name.replace("_","")
                    foms.append(m)
        ## determine affected lines from original file
        for fom in foms:
            fom.determine_affected_lines()

        for fom in foms:
            logging.debug(fom.c_name + ":" + fom.name + ":"  + str(fom.lines))
        self.foms = foms
        logging.info("loaded {} foms from {}".format(len(foms), directory))
        return foms
    
    def determine_affected_lines(self):
        ''' load the original program and determine different lines manually '''
        lines = []
        mutant_lines = self.code.splitlines()
        original_lines = self.original_code.splitlines()
        # check that has the right number of lines. if not, return -1
        if len(mutant_lines) != len(original_lines):
            self.lines = -1
            return 
        # if has correct number of lines, then determine affected lines
        i = 0
        with open(join(self.original_path, self.c_name + ".java")) as f:
            o_line = f.readline()
            while o_line != "":
                if o_line != mutant_lines[i] + "\n":
                    lines.append(i)
                i += 1
                o_line = f.readline()
        self.lines = lines
   
    @classmethod
    def set_base_path_all(self, mutants, path):
        for m in mutants:
            m.path = join(path, m.name + "/")
    
    @classmethod
    def set_original_base_path_all(self, mutants, path):
        for m in mutants:
            m.original_path = path
    
    #===========================================
    #======== Killing and Classifying ==========
    #===========================================

   
    # === basic mutant commands ===
    def compile(self):
        logging.debug("compiling mutant")
        java_compile("${CLASSPATH}:testset/:classes/:" + self.path, self.path, self.path)
    
    def compile_original(self):
        logging.debug("compiling original")
        java_compile("${CLASSPATH}:testset/:classes/:" + self.original_path, self.original_path, self.original_path)

    def run_original(self, timeout=3):
        logging.debug("running original")
        if not os.path.exists(join(self.original_path, self.c_name + ".class")):
            self.compile_original()
        self.original_output = java_run("${CLASSPATH}:testset/:classes/:" + self.original_path, "ChessUnitTestRunner", timeout)

    def run(self, timeout=3):
        logging.debug("running mutant")
        if not os.path.exists(join(self.path, self.c_name + ".class")):
            self.compile()
        self.output = java_run("${CLASSPATH}:testset/:classes/:" + self.path, "ChessUnitTestRunner", timeout)
    
    def run_original_if_needed(self, timeout=3):
        if self.original_output=="":
            self.run_original()

    def run_if_needed(self, timeout=3):
        if self.output=="":
            self.run()

    def kill(self, timeout=3, output=""):
        ''' runs mutant found in mutdir and compares output against "p_output"; if different than mutant is killed'''
        # specify what to compare output to
        if output == "":
            self.run_original_if_needed(timeout)
            output_to_compare = self.original_output
            logging.debug("killing with original output:")
        else:
            output_to_compare = output
            logging.debug("killing with provided output:")
        logging.debug(output_to_compare)
        self.run_if_needed(timeout)
        logging.debug("output:")
        logging.debug(self.output)

        if self.output == output_to_compare:
            self.killed = False # output same, not killed
            logging.debug(str(self) + " was not killed")
        else:
            self.killed = True # output different, killed
            logging.debug(str(self) + " was killed")
        return self.killed
    
    @classmethod
    def kill_all(self, muts, killeddir, notkilleddir, timeout=3):
        logging.info("Killing Mutants")
        num_killed = 0;
        num_not_killed = 0;
        original_output = ""
        for mut in muts:
            mut.original_output = original_output
            mut.kill(timeout)
            if original_output == "":
                original_output = mut.original_output
            if mut.killed:
                put_dir = killeddir
                num_killed += 1
            else: 
                put_dir = notkilleddir 
                num_not_killed += 1
            # copy mutant directory to appropriate location based on if killed
            copy_dir(mut.path, put_dir)
        logging.info("ran tests against {} muts, {} were killed and {} were not".format(len(muts), num_killed, num_not_killed))


    def set_unclassified_ancestors(self, classification = ""):
        ''' sets each unset ancestor to the passed classification '''
        for parent in self.parents:
            if parent.classification == '':
                parent.classification = classification
            parent.set_unclassified_ancestors(classification)

    @classmethod
    def load_mutant_classifications(self, class_file_path):
        ''' loads a list of equivalent and killable mutants from a file '''
        class_lines = load_file_to_string(class_file_path).split("\n")
        equiv_mutants = []
        killable_mutants = []
        mode = ""
        for i in xrange(len(class_lines)):
            line = class_lines[i]
            if line == "# equivalent":
                mode = "equivalent"
                continue
            elif line == "# not equivalent":
                mode = "killable"
            elif line == "":
                continue
            else:
                if mode == "equivalent":
                    equiv_mutants.append(line)
                elif mode == "killable":
                    killable_mutants.append(line)
                else:
                    logging.error("file should contain '# equivalent' and '# not equivalent' ")
                    sys.exit()
        logging.debug("equivalent list: " + str(equiv_mutants))
        logging.debug("killable list: " + str(killable_mutants))
        return equiv_mutants, killable_mutants
    

    #===========================================
    #============ Useful Strings ===============
    #===========================================
   
    @classmethod
    def log_unkilled_mutant_affected_lines(self, mutants):
        if len(mutants)==0:
            return
        logging.info("Unkilled mutants: ")
        for mut in mutants:
            if mut.killed == False:
                logging.info(mut)
                logging.info("\n" + mut.get_affected_lines_string(context=2))

    def get_affected_lines_string(self, context=2):
        ''' gets the affected lines in context '''
        divider = "===================================\n"
        divider_original = "=========== original ==============\n"
        divider_mutant = "=========== mutant ================\n"
        s_original = ""
        s_self = ""
        self_codelines = self.code.split("\n")
        original_codelines = self.original_code.split("\n")
        context_lines = self.get_context_lines(context)
        for i in xrange(len(self_codelines)):
            if i in context_lines:
                s_original += str(i) + ":" + original_codelines[i] + "\n"
                s_self += str(i) + ":" + self_codelines[i] + "\n"
        return divider_original + s_original + divider_mutant + s_self + divider
    
    def get_context_lines(self, context):
        ''' returns a list of lines that surround a list of lines by at least context'''
        context_array=[]
        for i in xrange(len(self.lines)):
            for j in xrange(context):
                context_array.append(self.lines[i]-j)
                context_array.append(self.lines[i]+j)
        return frozenset(context_array)
    

    def __str__(self):
        out_str = "(" + self.c_name
        out_str += ":" + self.name
        out_str += ":" + str(self.lines)
        out_str += ":" + "killed=" + str(self.killed)
        #out_str += ":" + "path=" + str(self.path)
        #out_str += ":" + "original path=" + str(self.original_path)
        out_str += ")"
        return out_str

    def __repr__(self):
        return self.__str__()






#===========================================
#============== Module Code ================
#===========================================

def setup():
    '''parses command line arguments and sets up logging to console and log file'''
    # parse arguments
    actions=['test', 'all', 'get', 'kill_foms', '2om_classify', 'hom_classify']
    log_choices=['debug','info','warning','error','critical']
    log_dict={'debug':logging.DEBUG,
                'info':logging.INFO,
                'warning':logging.WARNING,
                'error':logging.ERROR,
                'critical':logging.CRITICAL}
    #parser = argparse.ArgumentParser(usage="%(prog)s [-h] -m -a [-l]", description="Perform BW Transform on a Fasta File")
    parser = argparse.ArgumentParser(description="Perform HOM classification using first order mutants")
    parser.add_argument("action", nargs=1, choices=actions, help="The action to perform")
    parser.add_argument("classname", nargs=1, help="The class to mutate")
    parser.add_argument("-l", "--log", nargs='?', choices=log_choices, default='info', help="Logging level")
    args = parser.parse_args()
    

    # set up logging to file
    logname = "run"
    logging.basicConfig(level=log_dict[args.log],
        format='%(asctime)s %(name)-5s %(levelname)-10s| %(message)s',
        datefmt='%Y/%m/%d %H:%M:%S',
        #filename=logname + ".log",
        filename= args.classname[0] + ".log",
        filemode='a')

    # set up logging to console
    console = logging.StreamHandler()
    formatter = logging.Formatter('%(asctime)s %(name)-5s %(levelname)-8s| %(message)s','%Y/%m/%d %H:%M:%S')
    console.setLevel(log_dict[args.log])
    logging.getLogger('').addHandler(console)
   
  
    # log the inputs
    logging.log(100, "=== run.py ===")
    logging.info("Action: " + str(args.action))
    logging.info("Logging Level: " + str(args.log))

    return args

#===========================================
#=========== System Operations =============
#===========================================

def syscall(command):
    proc = subprocess.Popen(command, stdout=subprocess.PIPE, shell=True)
    (out, err) = proc.communicate()
    return out, err
   
def java_compile(cp, srcdir, outdir, filename = "*.java"):
    command = "javac -cp " + cp + " -d " + outdir + " " + srcdir + "/" + filename
    logging.debug(command)
    return syscall(command)

def java_run(cp, main_class, timeout=0):
    ''' runs a java file '''
    command = "timeout " + str(timeout) + " java -cp " + cp + " " + main_class
    logging.debug(command)
    return syscall(command)

def copy_dir(fromdir, todir):
    ''' copies the contents of fromdir to todir '''
    if not os.path.exists(todir):
        os.mkdir(todir)
    command = "cp -r " + str(fromdir) + " " + str(todir)
    logging.debug(command)
    return syscall(command)

def clear_dir(dir_name):
    ''' clears the contents of a directory '''
    command = "rm -r " + join(dir_name, "*")
    logging.debug(command)
    return syscall(command)
    
def write_string_to_file(string, filepath):
    ''' write any string to a file '''
    with open(filepath, 'w') as f:
        f.write(str(string))
    
def load_file_to_string(filename):
    ''' load any file into a string '''
    with open(filename) as f:
        string = f.read()
    return string


def load_java_from_dir(directory):
    ''' load all files matching *.java into strings are return string array '''
    java_files = [f for f in listdir(directory) if isfile(join(directory, f)) and ".java" in f]
    java_codes = []
    class_names = []
    for jfile in java_files:
        class_names.append(jfile.split(".")[0])
        # java_codes contains (class name, code) tuples
        java_codes.append(load_file_to_string(join(directory, jfile)))
    return class_names, java_codes

def main():
    # setup sequence
    args = setup()

    homc = hom_classifier()
    proj_path = os.path.realpath('..')
    class_name = args.classname[0]
    #class_name = "Bishop"
    #class_name = "Rook"
    #class_name = "Pawn"

    if 'test' in args.action:
        logging.info("No tests specified")
    
    if 'all' in args.action:
        args.action = ['get','kill_foms','hom_classify','2om_classify']

    if 'get' in args.action:
        # setup directories
        mujava_fom_path = proj_path + "/muJava/result/" + class_name + "/"
        logging.info("Class: " + class_name)

        # clear directories with existing classes in them
        logging.info("Clearing existing mutants")
        classes_path = join(this_path, "classes/")
        original_path = join(this_path, "original/")
        highom_classifier_path = join(this_path, "hom_classifier/")
        twoom_classifier_path = join(this_path, "2om_classifier/")
        fom_kill_path = join(this_path, "fom_kill/")
        clear_dir(classes_path)
        clear_dir(original_path)
        clear_dir(highom_classifier_path)
        clear_dir(twoom_classifier_path)
        clear_dir(fom_kill_path)

        # copy over classes and original mutant
        logging.info("Copying classes and mutants from muJava directory")
        mujava_classes_path = join(proj_path, "muJava/classes/*")
        copy_dir(mujava_classes_path, classes_path)
        syscall("rm " + join(classes_path, class_name + ".class"))
        mujava_original_path = join(mujava_fom_path, "original/*")
        copy_dir(mujava_original_path, original_path)


        # load foms and write to appropriate locations
        foms = mutant.load_mujava_foms(mujava_fom_path)
        fom_base_path = join(proj_path, "hom_classifier/fom_kill/foms/")
        mutant.set_base_path_all(foms, fom_base_path)
        mutant.set_original_base_path_all(foms, original_path)
        mutant.write_all(foms)

    
    if 'kill_foms' in args.action:
        # load foms from file
        foms = mutant.load_all(join(this_path,"fom_kill/foms/"), join(this_path, "original/"))
        
        # kill all foms and copy to killed or umut directories
        mutant.kill_all(foms, join(this_path, 'fom_kill/killed/'), join(this_path, 'fom_kill/umuts/'))

        # log all unkilled foms
        mutant.log_unkilled_mutant_affected_lines(foms) 


    if '2om_classify' in args.action:
        # load umuts and cm set from file
        umuts = mutant.load_all(join(this_path,"fom_kill/umuts/"), join(this_path, "original/"))
        cms = mutant.load_all(join(this_path,"fom_kill/killed/"), join(this_path, "original/"))

        # create 2oms and run to classify each umut as killable or equivalent
        killable_path = join(this_path,"2om_classifier/killable/")
        equivalent_path = join(this_path,"2om_classifier/equivalent/")
        scratch_path = join(this_path, "2om_classifier/scratch/")
        
        homc.classify_umuts_w_2ndOM(umuts, cms, killable_path, equivalent_path, scratch_path)
       # homc.classify_umuts_w_2ndOM_parallel(umuts, cms, killable_path, equivalent_path, scratch_path)
    
        #score the classifier
        tk, fk, te, fe, precision, recall, accuracy, f_2, f_1, f_0_5 = homc.classifier_score(umuts, join(this_path, class_name + "_fom_classes")) 
        logging.info("true killable: " + str(tk))
        logging.info("false killable: " + str(fk))
        logging.info("true equivalent: " + str(te))
        logging.info("false equivalent: " + str(fe))
        logging.info("precision: " + str(precision))
        logging.info("recall : " + str(recall))
        logging.info("accuracy : " + str(accuracy))
        logging.info("f(2) : " + str(f_2))
        logging.info("f(1) : " + str(f_1))
        logging.info("f(0.5) : " + str(f_0_5))

    if 'hom_classify' in args.action:
        # load umuts 
        umuts = mutant.load_all(join(this_path,"fom_kill/umuts/"), join(this_path, "original/"))

        # create hom tree and run to classify each umut as killable or equivalent
        killable_path = join(this_path,"hom_classifier/killable/")
        equivalent_path = join(this_path,"hom_classifier/equivalent/")
        scratch_path = join(this_path, "hom_classifier/scratch/")
        
        homc.classify_umuts_w_HOM(umuts, killable_path, equivalent_path, scratch_path)

        #score the classifier
        tk, fk, te, fe, precision, recall, accuracy, f_2, f_1, f_0_5 = homc.classifier_score(umuts, join(this_path, class_name + "_fom_classes")) 
        logging.info("true killable: " + str(tk))
        logging.info("false killable: " + str(fk))
        logging.info("true equivalent: " + str(te))
        logging.info("false equivalent: " + str(fe))
        logging.info("precision: " + str(precision))
        logging.info("recall : " + str(recall))
        logging.info("accuracy : " + str(accuracy))
        logging.info("f(2) : " + str(f_2))
        logging.info("f(1) : " + str(f_1))
        logging.info("f(0.5) : " + str(f_0_5))
        
this_path = os.path.realpath('.')

if __name__=="__main__":
    main()
