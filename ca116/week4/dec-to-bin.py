#!/usr/bin/env python3

base = 2

n = int(input())
output = ""

while 0 < n:
    output = str(n % base) + output
    n = n // base
print(output)
