#!/bin/bash

# contains commands to perform some standard actions with muJava

command=$1
case $command in
""|"h"|"help")
    echo "options are 'help' 'setup' 'get' 'build' 'mutate' 'butate' 'test'"
    ;;
"setup")
    java mujava.makeMuJavaStructure
    ;;

"get")
	cp -r ../eclipseproject/src/ChessBoard.java ./src
	cp -r ../eclipseproject/src/ChessPiece.java ./src
	cp -r ../eclipseproject/src/King.java ./src
	cp -r ../eclipseproject/src/Queen.java ./src
	cp -r ../eclipseproject/src/Knight.java ./src
	cp -r ../eclipseproject/src/Bishop.java ./src
	cp -r ../eclipseproject/src/Pawn.java ./src
	cp -r ../eclipseproject/src/Rook.java ./src
	cp -r ../eclipseproject/bin/ChessUnitTests.class ./testset
	cp -r ../eclipseproject/bin/OverridenKing.class ./testset
	cp -r ../eclipseproject/bin/OverridenQueen.class ./testset
	cp -r ../eclipseproject/bin/OverridenKnight.class ./testset
	cp -r ../eclipseproject/bin/OverridenBishop.class ./testset
	cp -r ../eclipseproject/bin/OverridenPawn.class ./testset
	cp -r ../eclipseproject/bin/OverridenRook.class ./testset
	;;
"build")
    javac -d classes -cp src/ src/*.java 
    #javac -d testset -cp /usr/lib64/eclipse/dropins/jdt/plugins/org.junit_4.12.0.jar:classes/ testset/RomanTest.java
    ;;
"mutate")
    java mujava.gui.GenMutantsMain
    ;;
"butate")
    javac -d classes -cp src/ src/*.java 
    java mujava.gui.GenMutantsMain
    ;;
"test")
    java mujava.gui.RunTestMain
    ;;
"clean")
    rm -r result/*
    ;;
*)
    echo "command '"$command"' not recognized"
    ;;
esac
