#!/usr/bin/env python3

import sys
avail = int(sys.stdin.readline().strip())
capacity = sys.stdin.readline().split()

def buckets(avail, capacity):
    total = 0
    count = 0
    for num in capacity:
        total += int(num)
        if total <= avail:
            count += 1
    return count
print(buckets(avail, capacity))