#!/bin/bash

sh ./clean.sh

java -jar ../../MyCompiler.jar test.jsdb

echo "db was generated"

javac Main.java

echo "user's program compiled"

java Main

echo "user's program is running"
