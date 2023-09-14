#!/usr/bin/env python3

import sys
import string

banned = string.punctuation
banned = banned.replace("'", "")

dict = {}
lines = [line.strip().lower() for line in sys.stdin]
for line in lines:
    line = line.strip().split(" ")
    for word in line:
        for char in word:
            if char in banned:
                word = word.replace(char, "")
        if word not in dict:
            dict[word] = 1
        else:
            dict[word] += 1

for k, v in sorted(dict.items()):
    print(f'{k} : {v}')