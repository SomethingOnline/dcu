#!/usr/bin/env python3

i = 0
t = 0

while i < 10:
    n = int(input())
    if n < 0:
        n = -1 * n
        t += n
    else:
        t += n
    i += 1
print(t)
