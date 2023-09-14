#!/usr/bin/env python3

import sys
# Binary search (adapted from CA116)
def binsearch(query, sorted_list):

    '''Return True if query in sorted_list else False'''

    low = 0
    high = len(sorted_list) - 1

    while low <= high:
        mid = (low + high) // 2

        # print(f'{low} {mid} {high}')

        if sorted_list[mid] < query:
            # Search RHS
            low = mid + 1

        elif sorted_list[mid] > query:
            # Search LHS
            high = mid - 1

        else:
            # Found it
            return True

    # Not found
    return False

lines = [w.strip() for w in sys.stdin.readlines()]
sorted_list = sorted([w.lower() for w in lines])

print([line for line in lines if len(line) > 4 and binsearch(line.lower()[::-1], sorted_list)])
