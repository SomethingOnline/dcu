#!/usr/bin/env python3

# each bar 400 cals
# once he starts a bar he must finish it
import sys

lines = sys.stdin.readlines()
for line in lines:
    line = line.strip()
    cals = int(line)
    if cals == 0:
        print("0")
    elif cals <= 400:
        print("1")
    else:
        cals = cals + 399
        print(cals // 400)
