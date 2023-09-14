#!/usr/bin/env python3

import sys

max = int(sys.stdin.readline().strip())
cap = sys.stdin.readline().split(" ")
total = 0
count = 0
for num in cap:
    total += int(num)
    if total <= max:
        count +=1
print(count)
