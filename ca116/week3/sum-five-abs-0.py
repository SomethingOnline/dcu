#!/usr/bin/env python3

i = 0
t = 0
n = int(input())

while n != 0:
   if n < 0:
      n = - n
   t += n
   n = int(input())
   i += 1
print(t)
