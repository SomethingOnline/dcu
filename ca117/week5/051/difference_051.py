#!/usr/bin/env python3

# 2 lines read 
# print same lines in order
# third line highlights the difference between the 2 lines
# when match use "-"
# when dont match use "*"
# lines same len

# use nested for loops to compare or range 
# use .replace(char, "-",1) when match
# use .replace(char, "*", 1) when dont match

import sys
line1 = sys.stdin.readline().strip()
line2 = sys.stdin.readline().strip()
print(line1)
print(line2)
newline = []
for a,b in zip(line1, line2):
    if a != b:
        newline.append("*")
    else:
        newline.append("-")
print("".join(newline))
