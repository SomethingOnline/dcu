#!/usr/bin/env python3

if __name__ == "__main__":
    a = [8, 9, 4, 7, 2, 11]

i = 0
while i < len(a) / 2:
    tmp = a[0]
    a[0] = a[len(a) - i - 1]
    a[len(a) - i - 1] = tmp
    i += 1
    i = len(a) / 2
