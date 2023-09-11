#!/usr/bin/env python3
import sys

numbers = sys.stdin.readline().split()
newList = []
for i in numbers:
    newList.append(int(i))
sorted = (sorted(newList))
dict = {
    "A": sorted[0],
    "B": sorted[1],
    "C": sorted[2]
}

order = sys.stdin.readline().strip()
newline = []
for i in order:
    if i in dict:
        newline.append(str(dict[i]))
print(" ".join(newline))

