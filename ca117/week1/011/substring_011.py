#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.strip()
    split = lines.split(" ")
    code = split[0].lower()
    word = split[1].lower()
    if code in word:
        print("True")
    else:
        print("False")
