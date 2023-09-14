#!/usr/bin/env python3

a = int(input())
a = a % 10000
a = a // 100

b = (((a % 10) * 10) + (a // 10))
print(b)
