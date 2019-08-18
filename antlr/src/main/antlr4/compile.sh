#!/bin/sh
# Author: Andy zhou <ablozhou@gmail.com>
# Date 2019.8.15

#cd /usr/local/lib
#$ sudo curl -O https://www.antlr.org/download/antlr-4.7.2-complete.jar
#
#$ vi ~/.zshrc
#export CLASSPATH=".:/usr/local/lib/antlr-4.7.2-complete.jar:$CLASSPATH"
#alias antlr4='java -jar /usr/local/lib/antlr-4.7.2-complete.jar'
#alias grun='java org.antlr.v4.gui.TestRig'
#$ source ~/.zshrc
echo "run:\n\t$0 xxx.g4"
echo "compile g4 file: $1"
# java -jar /usr/local/lib/antlr-4.7.2-complete.jar  Apple.g4
java -jar /usr/local/lib/antlr-4.7.2-complete.jar -visitor -no-listener -encoding UTF-8 $1 
echo "g4 file compile finished!" 
echo "compile java file"
javac *.java
echo "done!"
# for test parse tree
# $ grun Apple prog -gui
# 100+2*34
#^D
