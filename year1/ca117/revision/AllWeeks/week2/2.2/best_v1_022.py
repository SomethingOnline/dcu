#!/usr/bin/env python3
import sys


filename = sys.argv[1]
dict = {}
try:
    with open(filename, "r") as f:
        for line in f:
            line = line.strip().split()
            dict[" ".join(line[1:])] = line[0]

    def tagger(item):
        return item[1]
    for k , v in sorted(dict.items(), key=tagger, reverse=True):
        print(f'Best student: {k}')
        print(f'Best mark: {v}')
        break
except ValueError:
    print(f'The file {filename} could not be opened')