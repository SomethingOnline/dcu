#!/usr/bin/env python3

import sys
file1 = sys.argv[1]
file2 = sys.argv[2]

fileAlist = []
fileBlist = []
with open(file1) as f:
    for line in f:
        line = int(line.strip())
        fileAlist.append(line)
with open(file2) as f:
    for line in f:
        line = int(line.strip())
        fileBlist.append(line)

i = 0
while i < len(fileAlist) and i < len(fileBlist):
    print(fileAlist[i])
    print(fileBlist[i])
    i += 1