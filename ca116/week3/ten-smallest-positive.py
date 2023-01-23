#!/usr/bin/env python3

smallest = 1000000
i = 0
while i < 10:
    n = int(input())
    if n >= 1:
        if n < smallest:
            smallest = n
    i += 1
print(smallest)
