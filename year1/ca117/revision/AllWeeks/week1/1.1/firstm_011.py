#!/usr/bin/env python3

import sys
def capitalize_m(string):
    line = string.split()
    newLine = []
    i = 0
    for word in line:
        if word[0] == "m" and i == 0:
            newLine.append(word.capitalize())
            i += 1
        else:
            newLine.append(word)
    return " ".join(newLine)
for line in sys.stdin:
    line = line.strip()
    print(capitalize_m(line))