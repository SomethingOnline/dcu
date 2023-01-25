#!/usr/bin/env python3

import sys
import string
lines = sys.stdin.readlines()

unique = []
for line in lines:
    word = line.strip().lower()
    for char in word:
        if char in string.punctuation:
            word = word.replace(char, "",1)
    words = word.split(" ")
    i = 0
    while i < len(words):
        if words[i] not in unique and len(words[i]) > 0:
            unique.append(words[i])
        i += 1
print(len(unique))
