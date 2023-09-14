#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.strip()
    dig = 0
    upper = 0
    lower = 0
    other = 0
    for char in lines:
        if char.isupper():
            upper = 1
        elif char.islower():
            lower = 1
        elif char.isnumeric():
            dig = 1
        else:
            other = 1
    print(dig + other + upper + lower)
