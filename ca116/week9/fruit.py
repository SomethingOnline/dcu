#!/usr/bin/env python3

import sys
words = sys.stdin.readlines()
fruit = {
    "apple": True,
    "pear": True,
    "orange": True,
    "banana": True,
    "cherry": True,
}
i = 0
while i < len(words):
    line = words[i].rstrip()
    if line in fruit:
        print(line)
    i += 1
