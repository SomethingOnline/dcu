#!/usr/bin/env python3

import sys

numbers = {
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

lines = sys.stdin.readlines()
for line in lines:
    line = line.strip().split()
    a = []
    for char in line:
        char = int(char)
        if char in numbers:
            a.append(numbers[char])
        else:
            a.append("unknown")
    print(" ".join(a))
