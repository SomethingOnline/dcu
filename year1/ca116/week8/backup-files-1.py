#!/usr/bin/env python3

import os
lines = os.listdir(".")

i = 0
while i < len(lines):
    if lines[i][len(lines[i]) - 4:] != ".bak":
        with open(lines[i]) as f_out:
            data = f_out.read()
        with open(lines[i] + ".bak", "w") as f_out:
            f_out.write(data)
    i += 1
