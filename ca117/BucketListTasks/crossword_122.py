#!/usr/bin/env python3

import sys
line = sys.stdin.readline().lower().split()
A, B = line[0], line[1]

common = []
for letter in A:
    if letter in B:
        common.append(letter)
lastCommon = (common[-1])

# Used rindex() to find the index of the Last Instance of the last common letter in the words.
indexW2 = B.rindex(lastCommon)
indexW1 = A.rindex(lastCommon)

for i in range(len(A)):
    if i == indexW1:
        print(B)
    else:
        grid = list("." * len(B))
        grid[indexW2] = A[i]
        print("".join(grid))
