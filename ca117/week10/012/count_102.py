#!/usr/bin/env python3

def count(string):
    if string == "":
        return 0
    else:
        return 1 + count(string[1:])
