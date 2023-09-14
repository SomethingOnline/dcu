#!/usr/bin/env python3
import sys
def addPlurals(string):
    es = ["ch", "sh", "x", "s", "z"]
    nouns = "aeiou"
    if string[-2:] in es or string[-1] in es:
        return string + "es"
    elif string[-2] not in nouns and string[-1] == "y":
        return string[:-1] + "ies"
    elif string[-1] == "f":
        return string[:-1] + "ves"
    elif string[-2:] == "fe":
        return string[:-2] + "ves"
    elif string[-1] == "o":
        return string + "es"
    else:
        return string + "s"
    
for line in sys.stdin:
    line = line.strip()
    print(addPlurals(line))