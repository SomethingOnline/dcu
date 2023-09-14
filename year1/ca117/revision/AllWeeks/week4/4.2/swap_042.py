#!/usr/bin/env python3

def swap_keys_values(d):
    newDict = {}
    for k , v in sorted(d.items()):
        newDict[v] = k
    return newDict