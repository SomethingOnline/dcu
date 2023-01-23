#!/usr/bin/env python3

import sys 

args = sys.argv[1:]
g = str(args)

s = input()
a = []
while s != "end":
    a.append(s)
    s = input()

i = 0
j = 0
while i < len(a):
    while j < len(a[i]) and not (a[i][j:len(g)] == g):
        j += 1
    if j < len(a[i]):
        print(a[i])
    i += 1
