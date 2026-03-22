#!/bin/bash

# Compile and run the java program

echo "Compiling and running the program.."

SRC_FILES=$(find . -name "*.java" | sort)
javac -d . $SRC_FILES

if [ $? -eq 0 ]; then
    echo "Compilation Successful!"
    echo "Running the program.."
    java -cp . Main
else
    echo "Compilation Failed!"
    exit 1
fi