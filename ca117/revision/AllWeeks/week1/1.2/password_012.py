#!/usr/bin/env python3
import sys
def numClasses(string):
    upper = 0
    lower = 0
    numeric = 0
    symbol = 0
    for i in string:
        if i.isupper():
            upper = 1
        elif i.islower():
            lower = 1
        elif i.isnumeric():
            numeric = 1
        else:
            symbol = 1
    count = upper + lower + numeric + symbol
    return count

for line in sys.stdin:
    line = line.strip()
    print(numClasses(line))