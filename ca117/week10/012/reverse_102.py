#!/usr/bin/env python3

def reverse(list):
    if len(list) == 0:
        return []
    else:
        return [list[-1]] + reverse(list[:-1])