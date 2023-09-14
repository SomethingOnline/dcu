#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()
i = 0
while i < len(a):
    content = a[i].split(" ")
    start = int(content[1])
    duration = int(content[2])
    end = (start + duration - 1) % 24
    start = str(start) + ":00"
    end = str(end) + ":50"
    content[1] = start
    content[2] = end
    print(" ".join(content))
    i += 1
