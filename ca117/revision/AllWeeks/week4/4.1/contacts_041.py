#!/usr/bin/env python3

import sys
fileName = sys.argv[1]
with open(fileName, "r") as f:
    contacts = {}
    lines = [line.strip().split() for line in f]
    for line in lines:
        contacts[line[0]] = line[1]
    names = [line.strip() for line in sys.stdin]
    for name in names:
        if name in contacts:
            print(f'Name: {name}')
            print(f'Phone: {contacts[name]}')
        else:
            print(f'Name: {name}')
            print(f'No such contact')