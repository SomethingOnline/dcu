#!/usr/bin/env python3

import sys

lines = sys.stdin.readlines()

def is_prime(num):
    if num <= 1:
        return False
    for i in range (2, num):
        if num % i == 0:
            return False
    return True

for line in lines:
    print('Primes:', [n for n in range(2, int(line) + 1) if is_prime(n)])

# print(is_prime(8))
# print(a)

# for line in lines:
#     print('PRIMES:', [n for n in range(2, int(line) + 1) if all(n % k for k in range(2, n))])