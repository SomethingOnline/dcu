#!/usr/bin/env python3

import sys

lines = sys.stdin.readlines()

for line in lines:
    line = line.strip().split()
    word1 = line[0].lower()
    copy = word1
    word2 = line[1].lower()
    if len(word1) == len(word2):
        for letter in word1:
            if letter in word2:
                word2 = word2.replace(letter,"", 1)
    if len(word2) == 0:
        print("True")
    else:
        print("False")


# Solution in class

import sys
def contains(left, right):
    
    for c in left:
        if c not in right:
            return False
        right = right.replace(c,"",1)
    return right == ""
