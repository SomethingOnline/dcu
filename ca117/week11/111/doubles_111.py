#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()
vowels = ['a', 'e', 'i', 'o', 'u']
dict = {}

for line in lines:
    line = line.strip().lower()
    prevchar = line[0]
    dict[line] = 0
    for char in line[1:]:
        if char in vowels:
            if prevchar == char:
                dict[line] += 1
            prevchar = char

maxValue = max(dict.values())
for k, v in sorted(dict.items()):
    if v == maxValue:
        print(k)
