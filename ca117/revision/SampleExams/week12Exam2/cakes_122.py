#!/usr/bin/env python3
import sys

for line in sys.stdin:
    line = sorted([int(t) for t in line.strip().split()], reverse=True)
    freebies = line[2::3]
    print(sum(line) - sum(freebies))