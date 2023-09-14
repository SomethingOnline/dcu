#!/usr/bin/env python3


if __name__ == "__main__":
    a = ["", "", "dog", "", "", "cat", "", "", "", "mouse"]

i = 0
c = 0
while i < len(a):
    if a[i] != "":
        c += 1
    i += 1
print(c)
