#!/usr/bin/env python

import sys

inputfile = sys.argv[1]
with open(inputfile) as f:
    nonoWords = [line.strip() for line in f]

lines = sys.stdin.readlines()
for line in lines:
    line = line.strip()
    for w in nonoWords:
        if w in line:
            line = line.replace(w, '@' * len(w))
    print(line)

