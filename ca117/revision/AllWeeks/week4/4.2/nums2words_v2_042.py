#!/usr/bin/env python3

import sys

numDict = {
    0: "zero",
    1: "one",
    2: "two",
    3: "three",
    4: "four",
    5: "five",
    6: "six",
    7: "seven",
    8: "eight",
    9: "nine",
    10: "ten"
}

for line in sys.stdin:
    line = line.strip().split()
    newLine = []
    for i in line:
        i = int(i)
        if i in numDict:
            newLine.append(numDict[i])
        else:
            newLine.append("unknown")
    print(" ".join(newLine))