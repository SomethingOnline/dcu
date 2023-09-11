# #!/usr/bin/env python3
import sys

lines = []
for line in sys.stdin:
    lines.append(line.strip())

def fiveReverse(list):
    fiveRev = []
    for line in list:
       line = line.strip().lower()
       if len(line) >= 5 and (line[::-1].lower() or line[::-1].capitalize() or line[::-1].upper()) in list:
           if line[0].isupper():
                fiveRev.append(line.capitalize())
           else:
                fiveRev.append(line)
    return fiveRev
print(fiveReverse(lines))