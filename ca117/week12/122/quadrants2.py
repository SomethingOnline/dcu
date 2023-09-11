#!/usr/bin/env python3

lines = ['3 4', '4 -4', '-3 -2', '-2 3']

# True = positive number, False = negative number
d = {(True, True): 1,                       # quadrant 1
    (True, False): 2,
    (False, False): 3,
    (False, True): 4
}

for line in lines:
    x, y = [int(t) for t in line.strip().split()]
    print(d[(x > 0, y > 0)])


