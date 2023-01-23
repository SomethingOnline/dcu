#!/usr/bin/env python3

t = 0
i = 0
while t != 1000:
    s = input()
    j = 0
    while j < len(s) and s[j] != "+":
        j += 1
    a = int(s[:j])
    b = int(s[j + 1:])
    t = a + b
    print(t)
