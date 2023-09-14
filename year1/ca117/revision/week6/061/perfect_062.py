#!/usr/bin/env python3

def get_divisors(n):
    divisors = []
    for i in range(1, n):
        if n % i == 0:
            divisors.append(i)
    divisors.append(n)
    return divisors

def get_proper_divisors(n):
    proper_divisors = []
    divisors = get_divisors(n)
    t = 0
    for i in divisors:
        if t + int(i) < n:
            proper_divisors.append(int(i))
    return proper_divisors

def is_perfect(n):
    list = get_proper_divisors(n)
    total = sum(list)
    if n == total:
        return True
    return False    