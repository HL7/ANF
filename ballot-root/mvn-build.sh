#!/bin/sh
source ~/.bash_profile
mvn -e install
osascript openpdf.scpt
