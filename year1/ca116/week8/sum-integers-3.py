#!/usr/bin/env python3

import sys
args = sys.argv[1:]
print(args)
t = 0
i = 0

while i < len(args):
    with open(args[i]) as f_out:
        n = f_out.readline().strip()
        print(n)
        while 0 < len(n):
            t += int(n)
            n = f_out.readline().strip()
            print(n)
    i += 1
print(t)
