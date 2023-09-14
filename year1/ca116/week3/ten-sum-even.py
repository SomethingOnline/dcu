#!/usr/bin/env python3

i = 0
t = 0

while i < 10:
    n = int(input())
    if n % 2 == 0:
        t += n
    i += 1
print(t)
