#!/usr/bin/env python3

import sys
tokens = sys.stdin.readline().split()
nums = []
for i in tokens:
    nums.append(int(i))
nums.sort()
abc = {
    "a":nums[0],
    "b":nums[1],
    "c":nums[2],
}
order = sys.stdin.readline().strip().lower()
output = ""
for letter in order:
    output += f"{abc[letter]} "

print(output.strip())