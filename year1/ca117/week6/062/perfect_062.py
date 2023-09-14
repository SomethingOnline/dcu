#!/usr/bin/env python3

def get_divisors(n):
    divisors = []
    for i in range(1,n + 1):
        if n % i == 0:
            divisors.append(i)
    return sorted(divisors)

def get_proper_divisors(n):
    return get_divisors(n)[:-1]

def is_perfect(n):
    list = get_proper_divisors(n)
    t = 0
    for i in list:
        i = int(i)
        t += i
    if t == n:
        return True
    return False

def main():

    print(get_divisors(6))
    print(get_proper_divisors(6))
    print(is_perfect(6))

    numbers = [1,2,3,4,5,6,28,496,8128,8129]

    for n in numbers:
        print(is_perfect(n))