#!/usr/bin/env python3

s = input()
i = 0
t = 0

while i < len(s):
    j = i
    while j < len(s) and s[j] != "+":
        j += 1
    t = t + int(s[i:j])
    i = j + 1
print(t)
