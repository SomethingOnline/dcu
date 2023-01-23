#!/usr/bin/env python3

import os
files = os.listdir(".")

i = 0
while i < len(files):
    line = files[i].split(".")
    if line[-1] == "py":
        print(".".join(line))
    i += 1
