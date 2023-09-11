#!/usr/bin/env python3

import sys
import string
lines = sys.stdin.readlines()
noDupes = []
for line in lines:
    line = line.strip().split()
    newLine = []
    for word in line:
        if word.lower()[-1] in string.punctuation:
            if word.lower()[:-1] not in noDupes:
                noDupes.append(word.lower()[:-1])
                newLine.append(word)
            else:
                newLine.append('.')
        elif word.lower() not in noDupes:
            noDupes.append(word.lower())
            newLine.append(word)
        else:
            newLine.append('.')
    print(" ".join(newLine))

