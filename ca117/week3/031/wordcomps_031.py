#!/usr/bin/env python3

import sys
lines = []
for line in sys.stdin:
    lines.append(line.strip())


print("Words containing 17 letters:", [line for line in lines if len(line) == 17])
print("Words containing 18+ letters:", [line for line in lines if len(line) >= 18])
print("Words with 4 a's:", [line for line in lines if (line.count("a") + line.count("A")) == 4])
print("Words with 2+ q's:", [line for line in lines if (line.count("q") + line.count("Q")) >= 2])
print("Words containing cie:", [line for line in lines if "cie" in line])
print("Anagrams of angle:", [line for line in lines if sorted(line.lower()) == sorted("angle") and line.lower() != "angle"])