#!/usr/bin/env python3

import sys

i = 0
left_side = []
for line in sys.stdin:
    line = line.strip()
    if i % 2 == 0:
        print(line)
    else:
        left_side.append(line) 
    i += 1

for line in reversed(left_side):
    print(line)
