#!/usr/bin/env python3

import sys

def get_middle_char(string):
    if len(string) % 2 == 0:
        return "No middle character!"
    else:
        middleLen = len(string) // 2
        return string[middleLen]




for line in sys.stdin:
    line = line.strip()
    print(get_middle_char(line))