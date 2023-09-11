#!/usr/bin/env python3
import sys

a = []
lines = sys.stdin.readlines()
for line in lines:
    line = line.strip()
    a.append(len(line))
longest = max(a)

def centerString(line):
    return f'{line:^{longest}s}'

for line in lines:
    print(centerString(line.strip()))