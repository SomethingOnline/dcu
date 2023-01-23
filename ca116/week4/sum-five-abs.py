#!/usr/bin/env python3

i = 0
t = 0
while i < 5:
    n = int(input())
    if n < 0:
        n = -n
        t += n
    else:
        t += n
    i += 1
print(t)
