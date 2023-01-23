#!/usr/bin/env python3

import sys
import math

for lines in sys.stdin:
    lines = lines.strip()
    print(f'{math.pi:.{lines}f}')