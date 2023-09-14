#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()

n = int(input())
i = 0
while i < len(a):
    if int(a[i].split(" ")[0]) == n:
        print(a[i])
    i += 1
