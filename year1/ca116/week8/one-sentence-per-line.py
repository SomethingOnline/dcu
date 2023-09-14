#!/usr/bin/env python3

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()
text = " ".join(a)
content = text.split(".")
i = 0
while i < len(content):
    c = content[i]
    c = c.split()
    if 0 < len(c):
        print(" ".join(c) + ".")
    i += 1
