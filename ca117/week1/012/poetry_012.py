#!/usr/bin/env python3

import sys

lines = sys.stdin.readlines()
a = []
for line in lines:
    line.strip()
    a.append(len(line))
long = max(a) - 1
for line in lines:
    line = line.strip()
    print(f'{line:^{long}s}')