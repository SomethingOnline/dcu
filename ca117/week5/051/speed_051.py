#!/usr/bin/env python3

import sys

# split lines into T and D 
# have prev and cur Values
# update prev at the end of the value after appending the speed val to list
# speed = dist/time
# speed = rounded down to nearest integer

lines = sys.stdin.readlines()
prevTime, prevDist = [int(t) for t in lines[0].strip().split()]

speeds = []
for line in lines[1:]:
    line = line.strip().split()
    line = [int(t) for t in line]
    curTime , curDist = line
    speed = (curDist - prevDist) // (curTime - prevTime)
    speeds.append(speed)
    prevDist, prevTime = curDist, curTime
print(max(speeds))
