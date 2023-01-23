#!/usr/bin/env python3

s = input()
while s != "end":
    content = s.split(" ")
    code = content[5:]
    print(" ".join(code))
    s = input()
