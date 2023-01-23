#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

i = 0
count = 0
while i < len(lines):
    count += int(lines[i])
    i += 1
print(count)
