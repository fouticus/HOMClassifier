# [new, gen, run, rm] [s]
s=session
cp="mujava.jar:commons-io-2.4.jar:openjava.jar:hamcrest-core-1.3.jar:junit-4.12.jar"
#class="*"
class="Bishop"

all:

t:
	head -1 Makefile

new: rm 
	java mujava.cli.testnew $s
	cp ./src/${class}.java ./$s/src/
	cp ./classes/*.class ./$s/classes/
	cp ./testset/*.class ./$s/testset/

gen: 
	java mujava.cli.genmutes $s

run:
	java mujava.cli.runmutes ChessUnitTests $s

rm: 
	-rm -r $s
