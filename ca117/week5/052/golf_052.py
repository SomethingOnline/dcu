#!/usr/bin/env python3

import sys
lines = sys.stdin.readlines()

disqual = []
dict = {}
for line in lines:
    line = line.strip().split()
    name = " ".join(line[:-3])
    score = line[-3:]
    t = 0
    try:
        for num in score:
            t += int(num)
        dict[name] = t
    except ValueError:
        disqual.append(name)

def tagger(item):
    return item[1]

# sort on value
for name, score in sorted(dict.items(), key=tagger):
    print(f"{name}: {score}")

disqualified = ", ".join(disqual)
if len(disqual) > 0:
    print(f"Disqualified: {disqualified}")
