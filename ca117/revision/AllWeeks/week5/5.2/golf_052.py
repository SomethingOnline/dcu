#!/usr/bin/env python3
import sys
# valid = pos integer

dict = {}
disqualified = []
for line in sys.stdin:
    line = line.strip().split()
    name = " ".join(line[:-3])
    scores = list(line[-3:])
    total = 0
    for i in scores:
        try:
            total += int(i)
        except ValueError:
            if name not in disqualified:
                disqualified.append(name)
    if name not in disqualified:
        dict[name] = total

def tagger(item):
    return item[1]

for k, v in sorted(dict.items(), key=tagger):
    print(f'{k}: {v}')
if len(disqualified) > 0:
    print(f'Disqualified: {", ".join(disqualified)}')