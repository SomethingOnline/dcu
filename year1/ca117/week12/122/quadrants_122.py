#!/usr/bin/env python3

import sys

d = {
    (True, True): 1,
    (True, False): 2,
    (False, False): 3,
    (False, True): 4
}

for line in sys.stdin:
    line = line.split()
    x = int(line[0])
    y = int(line[-1])
    print(d[(x>0, y>0)])
