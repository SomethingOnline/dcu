#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()
translation = {
    "one": "eins",
    "two": "zwei",
    "three": "drei",
    "four": "vier",
    "five": "funf",
    "six": "sechs",
    "seven": "sieben",
    "eight": "acht",
    "nine": "neun",
    "ten": "zehn",
}

i = 0
while i < len(lines):
    word = lines[i].rstrip()
    if word in translation:
        print(translation[word])
    i += 1
