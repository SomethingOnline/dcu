#!/usr/bin/env python3

import sys

def palindrome(line):
    line = line.lower()
    for i in line:
        if not i.isalnum():
            line = line.replace(i, "")
    return line[::-1] == line
for line in sys.stdin:
    line = line.strip()
    print(palindrome(line))