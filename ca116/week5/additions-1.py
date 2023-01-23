#!/usr/bin/env python3


i = 0
while i < 10:
    s = input()
    j = 0
    while j < len(s) and s[j] != "+":
        j += 1
    if j < len(s):
        a = int(s[:j])
        b = int(s[j + 1:])
        print(a + b)
    i += 1
