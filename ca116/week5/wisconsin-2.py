#!/usr/bin/env python3

s = input()
count = 0
while s != "end":
    i = 0
    while i < len(s) - 1:
        if s[i] == "," and (s[i + 1:i + 3] == "WI"):
            count += 1
        i += 1
    s = input()
print(count)
