#!/bin/bash

for num in 1 2 3 4 5 6 7 8 9 10 11 12 13 14
do
    cd "test$num"
    echo "test$num"
    cat test.jsdb
    echo
    sh ./test.sh
    sh ./clean.sh
    cd ../
done

echo
echo "exit"