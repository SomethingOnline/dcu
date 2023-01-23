#!/usr/bin/env python3

s = input()
i = 0
a = []
while s != "end":
    a.append(s)
    i += 1
    s = input()
i = 0
while i < len(a):
    print(i, len(a), a[i])
    i += 1
