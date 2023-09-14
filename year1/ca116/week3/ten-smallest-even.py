#!/usr/bin/env python3

i = 0
smallest = 10000000

while i < 10:
    n = int(input())
    if n % 2 == 0:
        if n < smallest:
            smallest = n
    i += 1
print(smallest)
