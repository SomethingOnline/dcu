#!/usr/bin/env python3

import sys

number = sys.stdin.readline().split()
sortNumbers = sorted([int(t) for t in number])

letter = 'ABCDEF'
z = zip(letter, sortNumbers)

d = {k:v for k,v in z}
# print(d)
order = sys.stdin.readline().strip()

# for letter in order:
#     print(letter)
output = [str(d[letter]) for letter in order]
print(" ".join(output))