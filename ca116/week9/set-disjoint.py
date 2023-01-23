#!/usr/bin/env python3

with open("a.txt") as f:
    n = f.readlines()
with open("b.txt") as f_out:
    m = f_out.readlines()

files1 = {}
files2 = {}
Check = False
i = 0
while i < len(n):
    word = n[i].strip()
    files1[word] = True
    i += 1
i = 0
while i < len(m):
    word = m[i].strip()
    files2[word] = True
    if word in files2 and word in files1:
        Check = True
    i += 1

if Check is True:
    print("intersecting")
else:
    print("disjoint")
