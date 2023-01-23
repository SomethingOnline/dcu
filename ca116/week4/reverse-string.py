#!/usr/bin/env python3

s = input()
i = 0
total = ""
while i < len(s):
    total = total + s[len(s) - 1 - i]
    i += 1
print(total)
