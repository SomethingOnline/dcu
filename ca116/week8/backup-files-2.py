#!/usr/bin/env python3


import os
files = os.listdir(".")

i = 0
while i < len(files):
    if os.path.isfile(files[i].rstrip()):
        if files[i][len(files[i]) - 4:] != ".bak":
            with open(files[i]) as f:
                lines = f.read()
            with open(files[i] + ".bak", "w") as f:
                f.write(lines)
    i += 1
