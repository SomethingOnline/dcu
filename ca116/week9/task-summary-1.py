#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()
seen = {}
i = 0
while i < len(lines):
    curr_file = lines[i].rstrip().split(".")
    name = curr_file[0] + "." + curr_file[1]
    seen[name] = curr_file[-1]
    i += 1
for keys in seen:
    if seen[keys] == "correct":
        print(keys)
