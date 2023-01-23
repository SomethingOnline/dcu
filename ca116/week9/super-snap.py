#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()
seen = {}
i = 0
while i < len(lines) and (lines[i].rstrip() not in seen):
    seen[lines[i].rstrip()] = True
    i += 1
if i < len(lines):
    print("snap:", lines[i].rstrip())
