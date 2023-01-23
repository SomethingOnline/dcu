#!/usr/bin/env python3

import sys

for lines in sys.stdin:
    lines = lines.strip()
    print(lines.replace("m", "M", 1))
