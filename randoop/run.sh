#!/bin/bash

# contains commands to perform some standard actions with Randoop

command=$1
case $command in 
""|"h"|"help")
    echo "options are 'gentests' 'compileRunner'"
    ;;
"gentests")
    classpath=$2
    classlist=$3
    timelimit=$4
    maxtests=$5
    outdir="src/test"
    java -ea -classpath randoop-2.1.4.jar:$classpath randoop.main.Main gentests --classlist=$classlist --timelimit=$timelimit --junit-output-dir=$outdir --no-error-revealing-tests=true --outputlimit=$maxtests
    ;;
"compileRunner")
    junitdir=.
    junitpath=$junitdir/junit-4.12.jar
    hamcrestpath=$junitdir/hamcrest-core-1.3.jar
    srcpath="src/"
    testsrcpath="src/test/"
    runnersrc="TestRunner.java"
    outdir="bin/test"
    termcommand="javac -d $outdir -cp $junitpath:$hamcrestpath:$srcpath:$testsrcpath $testsrcpath$runnersrc"
    echo $termcommand
    $termcommand
    ;;
*)
    echo "command '"$command"' not recognized"
    ;;
esac
