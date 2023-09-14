#!/usr/bin/env python3
import sys

def getLargestUnique(list):
    uniques = [int(t) for t in list if list.count(t) == 1]
    if len(uniques) == 0:
        return "none"
    return max(uniques)

for line in sys.stdin:
    line = line.strip().split()
    print(getLargestUnique(line))