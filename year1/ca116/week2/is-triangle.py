#!/usr/bin/env python3

a = int(input())
b = int(input())
c = int(input())

if a + b > c and c + a > b and b + c > a:
    print("yes")
else:
    print("no")
