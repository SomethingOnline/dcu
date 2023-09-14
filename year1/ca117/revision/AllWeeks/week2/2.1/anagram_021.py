#!/usr/bin/env python3

import sys

def anagram(list):
    code = list[0]
    word = list[1]
    for i in code:
        if i in word:
            word = word.replace(i, "", 1)
            code = code.replace(i, "", 1)
    return (len(code) + len(word) == 0)

for line in sys.stdin:
    line = line.split()
    print(anagram(line))
