#!/usr/bin/env python3

import sys

file_name = sys.argv[1]

translations = {}
with open(file_name) as f:
    lines = f.readlines()
    line = [line.strip().split() for line in lines]
    for c in line:
        translations[c[0]] = c[1]

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
    #print(" ".join(a))
    words = [word.strip() for word in a]
    translated = []
    for n in words:
        if n in translations:
            translated.append(translations[n])
    print(" ".join(translated))
