#!/usr/bin/env python3

import sys


lines = sys.stdin.readlines()

for line in lines:
    line = line.split()
    roots = []
    a = int(line[0])
    b = int(line[1])
    c = int(line[2])
    try:
        posTopLine = -b + (((b ** 2) - 4*(a)*(c)) ** 0.5)
        negTopLine = -b - (((b ** 2) - 4*(a)*(c)) ** 0.5)
        bottomLine = 2 * a
        x = round(posTopLine / bottomLine, 1)
        y = round(negTopLine / bottomLine, 1)
        bigger = max(x, y)
        smaller = min(x, y)
        print(f'{smaller}, {bigger}')
    except TypeError:
        print("None")