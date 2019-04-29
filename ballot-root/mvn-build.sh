#!/bin/sh
source ~/.bash_profile
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/
export M2_HOME=/Library/Java/apache-maven
mvn -e clean install
osascript openpdf.scpt
