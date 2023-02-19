#!/usr/bin/env python3

import sys

lines = sys.stdin.readlines()
start = lines[0].strip()
order = lines[1].strip()

def A(list):
    tmp = list[0]
    list[0] = list[1]
    list[1] = tmp
    return list
def B(list):
    tmp = list[1]
    list[1] = list[2]
    list[2] = tmp
    return list
def C(list):
    tmp = list[0]
    list[0] = list[2]
    list[2] = tmp
    return list

prizeList = "123"
prize = list(prizeList.replace(start, "0"))
for char in order:
    if char == "A":
        A(prize)
    elif char == "B":
        B(prize)
    elif char == "C":
        C(prize)
print(prize.index("0") + 1)