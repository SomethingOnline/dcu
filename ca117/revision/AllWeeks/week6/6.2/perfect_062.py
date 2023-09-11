#!/usr/bin/env python3

def get_divisors(number):
    divisors = []
    for i in range(1, number + 1):
        if number % int(i) == 0:
            divisors.append(int(i))
    return sorted(divisors)

def get_proper_divisors(number):
    divisors = get_divisors(number)
    proper_divisors = []
    total = 0
    for i in divisors:
        if total + i < number:
            total + i
            proper_divisors.append(i)
    return proper_divisors

def is_perfect(number):
    proper_divisors = get_proper_divisors(number)
    return (sum(proper_divisors) == number)

