#!/usr/bin/env python3

import os
files = os.listdir(".")

i = 0
while i < len(files):
    with open(files[i]) as f_out:
        content = f_out.readlines()
        if len(content) > 0:
            lines = files[i].split(".")
            if lines[-1] == "py":
                print(".".join(lines))
    i += 1
