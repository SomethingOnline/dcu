#!/usr/bin/env python3

import sys

vowels = ["a","e","i","o","u"]
endings = ["ch","sh","x","s","z"]

for word in sys.stdin:
    word = word.strip()
    if word[-2:] in endings or word[-1] in endings:
        print(word + "es")
    elif word[-2] not in vowels and word[-1] == "y":
        print(word[:-1] + "ies")
    elif word[-1] == "f":
        print(word[:-1] + "ves")
    elif word[-2:] == "fe":
        print(word[:-2] + "ves")
    elif word[-1] == "o":
        print(word + "es")
    else:
        print(word + "s")
