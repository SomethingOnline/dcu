#!/usr/bin/env python3

import sys
files = sys.stdin.readlines()
i = 0
a = []
while i < len(files):
    content = files[i].strip()
    content = content.split("/")
    a.append(content[-1])
    i += 1
k = 0
while k < len(a):
    print(a[k])
    k += 1
