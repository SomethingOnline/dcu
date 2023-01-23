#!/usr/bin/env python3

n = int(input())
smallest = 100
i = 1

while i < 10:
    n = int(input())
    if n < smallest:
        smallest = n
    i += 1
print(smallest)
