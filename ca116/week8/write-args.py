#!/usr/bin/env python3

import sys
file_name = sys.argv[1]
num = sys.argv[2:]

with open(file_name, "w") as f_out:
    i = 0
    while i < len(num):
        f_out.write(num[i] + "\n")
        i += 1
