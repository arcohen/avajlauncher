#!/bin/bash

find * -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java Avajlauncher scenario.txt

rm aircrafts/*.class
rm weather/*.class
rm control/*.class
rm exeptions/*.class
rm Avajlauncher.class
