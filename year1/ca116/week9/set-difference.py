#!/usr/bin/env python3

with open("a.txt") as f:
    n = f.readlines()
with open("b.txt") as f_out:
    m = f_out.readlines()
file1 = {}
file2 = {}

i = 0
while i < len(n):
    word = n[i].strip()
    file1[word] = True
    i += 1
i = 0
while i < len(m):
    word = m[i].strip()
    file2[word] = True
    i += 1
i = 0
while i < len(n):
    word = n[i].strip()
    if word not in file2:
        print(word)
    i += 1
