#!/usr/bin/env python3

import sys

vowels = {
    "a": 0,
    "e": 0,
    "i": 0,
    "o": 0,
    "u": 0,
}

def checkvowels(w):
    return "a" in w and "e" in w and "i" in w and "o" in w and "u"

lines = [line.strip().lower() for line in sys.stdin]
for line in lines:
    for char in line:
        if char in vowels:
            vowels[char] += 1

max_len = (len(str(max(vowels.values()))))

def tagger(item):        # job is the return the attribute we are interested on sorting on - item will be the full tuple - item[1] is the value (key, value)
    return item[1]

for k, v in sorted(vowels.items(), key=tagger, reverse=True):          # key = function of what u want to sort
    print(f'{k} : {v:>{max_len}}')                           