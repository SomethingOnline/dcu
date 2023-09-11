#!/usr/bin/env python3

import sys

lines = ['7 4 6', '5', '7 9 4 6','7 4', '10 10 10 10 10 10 10']

for line in lines:
    cakes = sorted([int(t) for t in line.strip().split()], reverse=True)
    #print(cakes)
    freebies = cakes[2::3]
    #print(freebies)
    price = (sum(cakes) - sum(freebies))
    print(price)