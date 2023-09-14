#!/usr/bin/env python3
import sys

# speed = distance / time

line0 = sys.stdin.readline().split()
prevT, prevD = int(line0[0]), int(line0[1])
speeds = []
for line in sys.stdin:
    line = line.strip().split()
    curT, curD = int(line[0]), int(line[1])
    speed = (curD - prevD) // (curT - prevT)
    speeds.append(speed)
    prevT, prevD = curT, curD
print(max(speeds))
