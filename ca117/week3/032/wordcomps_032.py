#!/usr/bin/env python3

import sys

def checkvowels(w):
    return "a" in w and "e" in w and "i" in w and "o" in w and "u" in w

lines = [line.strip() for line in sys.stdin]
vowels = [w.strip() for w in lines if checkvowels(w)]
print(f'Shortest word containing all vowels: {min(vowels, key=len)}')
iary = [w.strip() for w in lines if w.endswith("iary")]
print(f'Words ending in iary: {len(iary)}')

max_e = max([w.lower().count("e") for w in lines])

e = [w for w in lines if w.lower().count("e") == max_e]
print(f"Words with most e's: {e}")
