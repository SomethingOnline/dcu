#!/usr/bin/env python3

import sys

def first_and_last(string):
    if len(line) > 2:
        firstChar = string[0].upper()
        lastChar = string[-1].upper()
        middleChars = string[1:-1].lower()
        return firstChar + middleChars + lastChar
    else:
        return line.upper()

for line in sys.stdin:
    line = line.strip()
    print(first_and_last(line))