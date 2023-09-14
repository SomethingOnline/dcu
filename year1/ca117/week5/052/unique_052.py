#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

for line in lines:
    line = line.strip().split()
    uniques = [int(t) for t in line if line.count(t) == 1]
    print(max(uniques, default="none"))