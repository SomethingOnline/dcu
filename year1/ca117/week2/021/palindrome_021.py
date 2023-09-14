#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

for line in lines:
    word = line.strip().lower()
    for char in word:
        if not char.isalnum():
            word = word.replace(char,"",1)
    print(word[::-1] == word)
