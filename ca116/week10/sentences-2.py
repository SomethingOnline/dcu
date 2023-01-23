#!/usr/bin/env python3

import sys
a = sys.stdin.read().split()

punctuation = {
    ".": True,
    "!": True,
    "?": True,
}

i = 0
j = 0
while i < len(a):
    while j < len(a) and a[j][len(a[j]) - 1] not in punctuation:
        j += 1
    j += 1
    c = a[i][0].capitalize()
    d = c + " ".join(a[i:j])
    print(c + "".join(d[2:]))
    i = j
