#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

for line in lines:
    num = int(line.strip())
    r = range(1, num + 1)
    replaced = ([0 if n % 3 != 0 else n for n in r])
    print(f'Non-multiples of 3 replaced: {replaced}')
