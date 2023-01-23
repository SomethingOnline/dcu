#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()

i = 0
while i < len(a):
    content = a[i].split(" ")
    if int(content[2]) > 1:
        print(" ".join(content))
    i += 1
