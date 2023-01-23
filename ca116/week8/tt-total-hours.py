#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()
count = 0
i = 0
while i < len(a):
    count = count + int(a[i].split()[2])
    i += 1
print(count)
