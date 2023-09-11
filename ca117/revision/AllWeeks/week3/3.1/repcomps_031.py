#!/usr/bin/env python3
import sys

for line in sys.stdin:
    line = line.strip()
    num = int(line)
    print(f'Non-multiples of 3 replaced: {[n if n % 3 == 0 else 0 for n in range(1, num + 1)]}')
    