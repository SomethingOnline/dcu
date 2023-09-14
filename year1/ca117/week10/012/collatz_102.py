#!/usr/bin/env python3

def collatz(n):
    print(n)
    if n == 1:
        return
    elif n % 2 == 0:
        return collatz(n // 2)
    else:
        return collatz((3 * n) + 1)