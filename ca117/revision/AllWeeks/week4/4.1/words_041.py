#!/usr/bin/env python3
import sys
import string
lines = [line.strip().lower() for line in sys.stdin]

banned = string.punctuation
banned = banned.replace("'", "")
dict = {}

for line in lines:
    line = line.split()
    for word in line:
        for char in word:
            if char in banned:
                word = word.replace(char, "", 1)
        if word not in dict:
            dict[word] = 1
        else:
            dict[word] += 1
for k,v in sorted(dict.items()):
    print(f'{k} : {v}')