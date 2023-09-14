#!/usr/bin/env python3


file_name = "input.txt"

with open("input.txt") as f_out:
    n = f_out.readlines()

i = 0
while i < len(n):
    print(n[i].rstrip())
    i += 1
