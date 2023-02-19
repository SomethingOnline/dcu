#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

for line in lines:
    line = line.strip().lower()
    alpha = "abcdefghijklmnopqrstuvwxyz"
    for char in line:
        if char in alpha:
            alpha = alpha.replace(char, "")
    if len(alpha) == 0:
        print("pangram")
    else:
        print(f"missing {alpha}")