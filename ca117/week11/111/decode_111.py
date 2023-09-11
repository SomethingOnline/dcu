#!/usr/bin/env python3

# After each vowel he adds a p followed by the vowel again.
# need vowel list
# could be done with enumerate and index?? 
# look over and try
import sys

vowels = ['a', 'e', 'i', 'o', 'u']
def decode(string):
    for vowel in vowels:
        string = string.replace(vowel + 'p' + vowel, vowel)
    return string
lines = sys.stdin.readlines()
for line in lines:
    print(decode(line.strip()))