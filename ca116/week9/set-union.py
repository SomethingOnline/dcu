#!/usr/bin/env python3

import sys

file_name = "a.txt"
with open(file_name) as f:
    n = f.readlines()
file_name = "b.txt"
with open(file_name) as f_out:
    m = f_out.readlines()
seen = {}
i = 0
while i < len(n):
    word = n[i].strip()
    if word not in seen:
        seen[word] = True
    i += 1
i = 0
while i < len(m):
    word = m[i].strip()
    if word not in seen:
        seen[word] = True
    i += 1
i = 0
list = list(seen.keys())
while i < len(list):
    print(list[i])
    i += 1
