#!/usr/bin/env python3

import sys

def get_name(string):
    splitString = string.split(".")
    firstName = splitString[0].capitalize()
    lastName = splitString[1].split('@')[0].capitalize()
    for i in lastName:
        if i.isnumeric():
            lastName = lastName.replace(i, "")
    return f'{firstName} {lastName}'
    

for line in sys.stdin:
    line = line.strip()
    print(get_name(line))