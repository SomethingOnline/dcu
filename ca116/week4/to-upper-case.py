#!/usr/bin/env python3

w = input()
i = 0
t = ""

while i < len(w):
    if ord(w[i]) >= 97 and ord(w[i]) <= 122:
        chup = ord(w[i])
        chup = chup - 32
        chup = chr(chup)
        t += chup
    else:
        t += w[i]
    i += 1
print(t)
