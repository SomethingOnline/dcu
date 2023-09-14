#!/usr/bin/env python3
import sys

def is_prime(n):
    if n == 1:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

for line in sys.stdin:
    line = line.strip()
    num = int(line)
    print(f'Primes: {[n for n in range(1, num + 1) if is_prime(n)]}')