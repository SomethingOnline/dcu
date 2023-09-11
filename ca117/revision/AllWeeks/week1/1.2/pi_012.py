#!/usr/bin/env python3
from math import pi
import sys

def numOfDecPlaces(num):
    return f'{pi:.{num}f}'
for line in sys.stdin:
    line = line.strip()
    print(numOfDecPlaces(line))
