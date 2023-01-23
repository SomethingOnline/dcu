#!/usr/bin/env python3

s = input()
i = 1
j = len(s) - 1 - i
while i < len(s) and (s[i] == s[j]):
    i += 1
    j = len(s) - i - 1
if i == len(s):
    print("palindrome")
