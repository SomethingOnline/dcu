#!/usr/bin/env python3

a = []
s = input()
while s != "end":
    a.append(int(s))
    s = input()
i = 0
while i < len(a):
    p = i
    j = p + 1
    while j < len(a):
        if a[j] > a[p]:
            p = j
        j += 1
    tmp = a[i]
    a[i] = a[p]
    a[p] = tmp
    i += 1
k = 0
while k < len(a):
    print(a[k])
    k += 1
