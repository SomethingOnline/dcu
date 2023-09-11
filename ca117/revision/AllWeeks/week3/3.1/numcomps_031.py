#!/usr/bin/env python3

import sys

for line in sys.stdin:
    line = line.strip()
    num = int(line)
    print(f'Multiples of 3: {[n for n in range(1, num + 1) if n % 3 == 0]}')
    print(f'Multiples of 3 squared: {[n ** 2 for n in range(1, num + 1) if n % 3 == 0]}')
    print(f'Multiples of 4 doubled: {[n * 2 for n in range(1, num + 1) if n % 4 == 0]}')
    print(f'Multiples of 3 or 4: {[n for n in range(1, num + 1) if n % 3 == 0 or n % 4 == 0]}')
    print(f'Multiples of 3 and 4: {[n for n in range(1, num + 1) if n % 3 == 0 and n % 4 == 0]}')