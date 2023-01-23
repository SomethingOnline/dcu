#!/usr/bin/env python3

import sys
lines = sys.stdin.read().strip().split()
sen = ""

ends = [".", "?", "!"]

i = 0
while i < len(lines):
   sen += lines[i]
   if lines[i][-1] in ends:
      sen += "\n"
   else:
      sen += " "
   i += 1
print(sen.strip())
