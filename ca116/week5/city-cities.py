#!/usr/bin/env python3

s = input()
while s != "end":
    i = 1
    while i < len(s) - 1:
        if (s[i:i + 4] == "City"):
            print((s[:i]) + (s[i:i + 4]))
        i += 1
    s = input()
