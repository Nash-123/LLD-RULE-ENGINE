#!/bin/bash

# Compile all Java files in one go, preserving correct dependency resolution.
# Use -d . so default-package classes (no package) are found by java Main.

SRC_FILES=$(find . -name "*.java" | sort)
javac -d . $SRC_FILES

if [ $? -eq 0 ]; then
    echo "Compilation Successful!"
    echo "To run the program, use the command: java Main"
else
    echo "Compilation Failed!"
    exit 1
fi