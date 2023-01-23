#!/usr/bin/env python3

import sys

with open("a.txt") as f:
    n = f.readlines()
with open("b.txt") as f_out:
    m = f_out.readlines()

file1 = {}
i = 0
while i < len(n):
    word = n[i].strip()
    if word not in file1:
        file1[word] = True
    i += 1
i = 0
file2 = {}
while i < len(m):
    word = m[i].strip()
    if word in file1:
        print(word)
    i += 1
