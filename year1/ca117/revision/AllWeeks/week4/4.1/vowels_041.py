#!/usr/bin/env python3
import sys

dict = {}
for i in 'aeiou':
    dict[i] = 0
lines = [line.strip().lower() for line in sys.stdin]

for line in lines:
    line = line.strip()
    for chars in line:
        if chars in dict:
            dict[chars] += 1

def tagger(item):
    return item[1]
lens = []
for v in sorted(dict.values()):
    lens.append(len(str(v)))
maxLens = max(lens)
for k , v in sorted(dict.items(), key=tagger, reverse=True):
    print(f'{k} : {v:{maxLens:d}}')