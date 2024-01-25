#!/usr/bin/env python3

def q1_sum(matrix):
    sum = 0
    for line in matrix:
        for num in line:
            if num % 2 == 0:
                sum += num
    print(sum)
List = [
    [1, 0, 2],
    [5, 5, 7],
    [9, 4, 3]
]
result = q1_sum(List)
