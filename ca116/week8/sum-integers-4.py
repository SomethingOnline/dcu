#!/usr/bin/env python3

import sys
args = sys.argv[1:]
i = 0
t = 0
a = []
while i < len(args):
    with open(args[i]) as f_out:
        n = f_out.readline().rstrip().split()
        while 0 < len(n):
            j = 0
            while j < len(n):
                a.append(n[j])
                j += 1
            n = f_out.readline().rstrip().split()
    i += 1
k = 0
while k < len(a):
    t += int(a[k])
    k += 1
print(t)
