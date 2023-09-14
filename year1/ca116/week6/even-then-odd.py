#!/usr/bin/env python3

n = input()
a = []
while n != "end":
    if int(n) % 2 == 1:
        a.append(n)
    else:
        print(n)
    n = input()
i = 0
while i < len(a):
    print(a[i])
    i += 1
