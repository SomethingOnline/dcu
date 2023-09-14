#!/usr/bin/env python3

def maximum(list=None):
    if len(list) == 1:
        return list[0]
    else:
        if list[0] > maximum(list[1:]):
            return list[0]
        else:
            return maximum(list[1:])