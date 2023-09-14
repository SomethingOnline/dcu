#!/usr/bin/env python3

n = input()
i = 0
t = 0

while i < len(n):
   t = ("*" * int(n[i]))
   print(t)
   i += 1
