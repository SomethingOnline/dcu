#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.strip()
    i = 0
    while i < len(lines) and not lines[i].isnumeric():
        i += 1
    names = lines[:i].split(".")
    print(names[0].capitalize() + " " + names[1].capitalize())
