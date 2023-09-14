#!/usr/bin/env python3

i = 0
s = input()

while i < len(s) and not ("0" < s[i] and s[i] < "9"):
    i += 1
if i < len(s):
    j = i
    while j < len(s) and ("0" < s[j] and s[j] < "9"):
        j += 1
    if j < len(s):
        print(s[i:j], i)
