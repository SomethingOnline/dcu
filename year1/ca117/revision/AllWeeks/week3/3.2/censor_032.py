#!/usr/bin/env python3
import sys
censorFile = sys.argv[1]


with open(censorFile, "r") as f:
    censored = ([line.strip() for line in f])
    lines = [line.strip() for line in sys.stdin]
    for line in lines:
        for word in censored:
            if word in line:
                line = line.replace(word, '@' * len(word))
        print(line)