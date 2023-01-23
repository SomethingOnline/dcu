#!/usr/bin/env python3

n = int(input())
n1 = 0
n2 = 1
i = 0
running = True
while i < n:
    if n1 >= n:
        running = False
    else:
        print(n1)
        nth = n1 + n2
        n1 = n2
        n2 = nth
        running = True
    i += 1
