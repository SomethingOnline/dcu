#!/usr/bin/env python3

import sys

filename = sys.argv[1]
dict = {}
try:
    with open(filename, "r") as f:
        for line in f:
            line = line.strip().split()
            try:
                dict[" ".join(line[1:])] = int(line[0])
            except ValueError:
                print(f'Invalid mark {line[0]} encountered. Skipping.')
    def tagger(item):
        return item[1]
    for k , v in sorted(dict.items(), key=tagger, reverse=True):
        print(f'Best student: {k}')
        print(f'Best mark: {v}')
        break
except ValueError:
   print(f'The file {filename} could not be opened')