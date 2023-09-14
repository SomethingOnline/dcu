#!/usr/bin/env python3

import sys
args = sys.argv[1:]

i = 0
t = 0
while i < len(args):
    t = t + int(args[i])
    i += 1
print(t)
