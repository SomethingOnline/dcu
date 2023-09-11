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
fileName = sys.argv[1]
dict = {}
with open(fileName, "r") as f:
    lines = f.readlines()
    line = [line.strip().split() for line in lines]
    for c in line:
        dict[c[0]] = c[1]

for line in sys.stdin:
    line = line.strip().split()
    newLine = []
    for num in line:
        num = int(num)
        if num in numDict:
            key = numDict[num]
            if key in dict:
                newLine.append(dict[key])
    print(" ".join(newLine))
        
