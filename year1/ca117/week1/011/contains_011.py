#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.strip()
    split = lines.split(" ")
    code = split[0].lower()
    word = split[1].lower()
    copy = word
    for letter in code:
        if letter in word:
            word = word.replace(letter, "")
    if len(word) == len(copy) - len(code):
        print("True")
    else:
        print("False")
