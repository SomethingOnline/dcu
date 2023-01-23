#!/usr/bin/env python3


url = input()
s = url.split("/")
i = 0
while i < len(s):
    n = s[i].split(":")
    i += 1
print(n)