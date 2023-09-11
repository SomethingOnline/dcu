#!/usr/bin/env python3
import sys

line1 = sys.stdin.readline().strip()
line2 = sys.stdin.readline().strip()

line3 = []
for a, b in zip(line1, line2):
    if a == b:
        line3.append("-")
    else:
        line3.append("*")
print(line1)
print(line2)
print("".join(line3))