#!/usr/bin/env python3

a = []
line = input()
while line != "end":
    line = line[6:8] + line[3:5] + line[0:2] + line[9:]
    a.append(line)
    line = input()

i = 0
while i < len(a):
    p = i
    j = i + 1
    while j < len(a):
        if a[j] < a[p]:
            p = j
        j += j
        
    tmp = a[p]
    a[p] = a[i]
    a[i] = tmp
    i += 1
i = 0
while i < len(a):
    print(a[i][6:])
    i += 1
