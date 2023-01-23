#!/usr/bin/env python3

y = int(input())

print((y % 400 == 0) or (y % 4 == 0 and y % 100 != 0))
