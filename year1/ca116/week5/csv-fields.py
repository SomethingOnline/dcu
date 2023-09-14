#!/usr/bin/env python3

a = input()
i = 0

while i < len(a):
    if a[i] == ",":
      print(a[:i])
      a = a[i + 1:]
      i = 0
    i = i + 1

i = 0
while i == 0:
  print(a)
  i = i + 1
