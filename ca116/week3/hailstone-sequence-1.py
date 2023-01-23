#!/usr/bin/env python3

n = int(input())
m = int(input())
i = 0
print(m)
while (i + 1) < n:
    if m % 2 == 0:
        m = int(m / 2)
    else:
        m = int((m * 3) + 1)
    print(m)
    i += 1
