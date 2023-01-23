#!/usr/bin/env python3

import sys

for line in sys.stdin:
    line = line.strip()
    print(line[0].upper() + line[1:-1].lower() + line[-1].upper())
