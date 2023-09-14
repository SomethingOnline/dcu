#!/usr/bin/env python3
import sys
import string
uniqueWords = []

for line in sys.stdin:
    line = line.lower()
    for i in line:
        if i in string.punctuation:
            line = line.replace(i, "", 1)
    line = line.split()
    for i in line:
        if i not in uniqueWords:
            uniqueWords.append(i)
print(len(uniqueWords))