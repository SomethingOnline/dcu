#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    if s not in a:
        a.append(s)
    s = input()
i = 0
while i < len(a):
    print(a[i])
    i += 1
