#!/usr/bin/env python3

x1 = int(input())
y1 = int(input())
r1 = int(input())
x2 = int(input())
y2 = int(input())
r2 = int(input())

d = ((((x2 - x1) ** 2) + (y2 - y1) ** 2) ** 0.5)
if d < r1 + r2:
    print("yes")
else:
    print("no")
