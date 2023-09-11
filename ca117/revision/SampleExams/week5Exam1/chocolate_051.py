#!/usr/bin/env python3
import sys
def getBars(calories):
    if calories == 0:
        return 0
    elif calories <= 400:
        return 1
    else:
        calories = calories + 399
        return calories // 400

for line in sys.stdin:
    line = int(line.strip())
    print(getBars(line))
