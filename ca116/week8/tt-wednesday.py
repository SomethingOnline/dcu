#!/usr/bin/env python3

s = input()
while s != "end":
    content = s.split(" ")
    if content[0] == "3":
        n = " ".join(content)
        print(n)
    s = input()
