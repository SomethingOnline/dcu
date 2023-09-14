#!/usr/bin/env python3

s = input()
i = 0
t = ""
w = ""
while i < len(s):
    if s[i] == " ":
        w = ""
    else:
        t += s[i]
    i += 1
print(t)
