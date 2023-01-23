#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.rstrip()
    chopped = lines[1:-1]
    if len(chopped) > 0:
        print(chopped)
