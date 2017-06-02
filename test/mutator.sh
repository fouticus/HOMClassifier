#!/bin/bash

p_path=$1
m1_path=$2
m2_path=$3
outpath=`dirname $m1_path`

#specify output directory

p=`basename $p_path`
m1=`basename $m1_path`
m2=`basename $m2_path`
echo $p

# create name of new mutant, sorting numbers of the mutants
m3=(m$(printf ${m1:1:${#m1}-1}${m2:1:${#m2}-1} | grep -o . | sort -n | tr -d "\n"))
echo $m3
m3_path=$outpath/$m3

# make copy of m1 and name m3
cp $m1_path $m3_path

# merge changes from m2 into m3 so it contains changes of m1 and m2. -q indicates quiet mode, 
merge -q $m3_path $p_path $m2_path
