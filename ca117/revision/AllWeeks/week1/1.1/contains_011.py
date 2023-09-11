#!/usr/bin/env python3
import sys

def contains(string):
    newline = string.split()
    code = newline[0].lower()
    word = newline[1].lower()
    for c in word:
        if c in code:
            code = code.replace(c, "", 1)
    return len(code) == 0
for line in sys.stdin:
    line = line.strip()
    print(contains(line))
