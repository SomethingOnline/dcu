#!/usr/bin/env python3

s = input()
a = []
i = 0
while s != "end":
    a.append(int(s))
    s = input()
n = int(input())
while i < len(a):
    print(a[i] + n)
    i += 1
