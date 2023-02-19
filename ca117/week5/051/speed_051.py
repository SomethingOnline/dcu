#!/usr/bin/env python3

import sys

# split lines into T and D 
# have prev and cur Values
# update prev at the end of the value after appending the speed val to list
# speed = dist/time
# speed = rounded down to nearest integer

line1 = sys.stdin.readline()
prevTime, prevDist = [int(t) for t in line1.strip().split()]

lines = sys.stdin.readlines()
speeds = []

for line in lines:
    curTime, curDist = [int(t) for t in line.strip().split()]
    speed = (curDist - prevDist) // (curTime - prevTime)
    speeds.append(speed)
    prevTime, prevDist = curTime, curDist
print(max(speeds))
