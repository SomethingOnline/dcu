#!/usr/bin/env python3

import sys

for line in sys.stdin:
    line = line.strip()
    if len(line) % 2 == 0:
        print("No middle character!")
    else:
        mid = len(line) // 2
        print(line[mid])
