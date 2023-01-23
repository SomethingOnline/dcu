#!/usr/bin/env python3

s = input()

i = 1
j = i - 1
while i < len(s) and not (s[i] == s[j]):
    i += 1
    j = i - 1
if i < len(s):
    print(s[j:i + 1])
