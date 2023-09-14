#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

with open("translation.txt") as f_out:
    n = f_out.readlines()

i = 0
translation = {}
while i < len(n):
    stripped = n[i].rstrip()
    words = stripped.split(" ")
    if words[0] not in translation:
        translation[words[0]] = words[1]
    i += 1

i = 0
while i < len(lines):
    word = lines[i].rstrip()
    if word in translation:
        print(translation[word])
    i += 1
