#!/usr/bin/env python3

i = 0
t = 0
f = 0
n = int(input())

while n != 0:
   if n < 0:
      f += n
   else:
      t += n
   n = int(input())
print(f, t)
