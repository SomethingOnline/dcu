#!/usr/bin/env python3

import os
line = "start.txt"
while os.path.isfile(line):
    with open(line) as f:
        line = f.readline().rstrip()
print(line)
