#!/usr/bin/env python3
import sys
dict = {
    (True, True): 1,
    (True, False): 2,
    (False, False): 3,
    (False, True): 4
}
for line in sys.stdin:
    x, y = (line.strip().split())
    x = int(x)
    y = int(y)
    print(dict[x>0, y>0])
