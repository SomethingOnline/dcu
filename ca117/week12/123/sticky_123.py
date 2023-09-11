#!/usr/bin/env python3
import sys

typed = sys.stdin.readline().split()
screen = sys.stdin.readline().split()

sticky = []
for i in range(len(typed)):
     for char in screen[i]:
        if (screen[i].count(char) == typed[i].count(char) * 2) and char not in sticky:
            sticky.append(char)

print(''.join(sorted(sticky)))