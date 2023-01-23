#!/usr/bin/env python3

i = 0
n = int(input())
while i < n:
    if i == 0 or i == n - 1:
        print("*" * n)
    else:
        print("*" + ((n - 2) * " ") + "*")
    i += 1
