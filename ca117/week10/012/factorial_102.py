#!/usr/bin/env python3


# !5 = !4 * 5
def factorial(n):
    if n == 1 or n == 0:
        return 1
    else:
        return n * factorial(n - 1)
    