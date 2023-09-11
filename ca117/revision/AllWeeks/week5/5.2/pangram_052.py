#!/usr/bin/env python3
import sys

alphabet = "abcdefghijklmnopqrstuvwxyz"

def pangram(string):
    string = string.lower()
    checks = [char in string for char in alphabet]
    missing = []
    if all(checks) == True:
        return("pangram")
    else:
        for a, b in zip(alphabet, checks):
            if b == False:
                missing.append(a)
    return f'missing {"".join(missing)}'


for line in sys.stdin:
    line = line.strip()
    print(pangram(line))