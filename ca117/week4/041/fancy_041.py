#!/usr/bin/env python3

import sys
inputs = sys.argv[1]
with open(inputs) as f:
    contacts = [line.strip().split() for line in f]
contactinfo = {}

for contact in contacts:
    contactinfo[contact[0]] = contact[1], contact[2]

for lines in sys.stdin:
    lines = lines.strip()
    print("Name:", lines)
    if lines in contactinfo:
        print("Phone:", contactinfo[lines][0])
        print("Email:", contactinfo[lines][1])
    else:
        print("No such contact")