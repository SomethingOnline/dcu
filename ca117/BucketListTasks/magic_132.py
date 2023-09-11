#!/usr/bin/env python3

import sys

def is_magic(n):
    while n > 0:
        digit = n % 10
        if digit != 3 and digit != 9:
            return False
        n = n // 10
    return True

def magic_number(k):
    number = 0
    count = 0
    while count < k:
        number += 1
        if is_magic(number) == True:
            count += 1
    return number

num = int(sys.stdin.readline().strip())
print(magic_number(num))