#!/usr/bin/env python3
import sys

def chop(string):
    newWord = string[1:len(string) - 1]
    return newWord


lines = sys.stdin.readlines()
for line in lines:
    line = line.strip()
    if len(line) > 2:
        print(chop(line))
