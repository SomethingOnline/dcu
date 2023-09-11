#!/usr/bin/env python3
import sys

numbers = sys.stdin.readline().strip().split()
letters = sys.stdin.readline().strip()
sortedList = (sorted(numbers))
sortedDict = {
    "A": sortedList[0],
    "B": sortedList[1],
    "C": sortedList[2],
    "D": sortedList[3],
    "E": sortedList[4],
    "F": sortedList[5]
}
a = []
for i in letters:
    i = i.strip()
    a.append(sortedDict[i])
print(" ".join(a))
