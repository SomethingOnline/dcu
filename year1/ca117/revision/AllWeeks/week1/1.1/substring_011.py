#!/usr/bin/env python3

import sys

def substring(string):
    newline = string.split()
    code = newline[0].lower()
    word = newline[1].lower()
    return code in word

for line in sys.stdin:
    line = line.strip()
    print(substring(line))

