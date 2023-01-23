#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(int(s))
    s = input()
smallest = a[0]
i = 0
pos = 0
while i < len(a):
    if a[i] < smallest:
        smallest = a[i]
        pos = i
    i += 1
print(pos)
