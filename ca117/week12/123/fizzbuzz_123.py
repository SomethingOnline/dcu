#!/usr/bin/env python3
import sys

# integers = X, Y, N 
# (1 <= X <= Y <= N <= 1000)

line = sys.stdin.readline().strip().split()
X = int(line[0])
Y = int(line[1])
N = int(line[2])
for i in range(1, N + 1):
    i = int(i)
    if i % X == 0 and i % Y == 0:
        print("fizzbuzz")
    elif i % X == 0 and i % Y != 0:
        print("fizz")
    elif i % Y == 0 and i % X != 0:
        print("buzz")
    else:
        print(i)
