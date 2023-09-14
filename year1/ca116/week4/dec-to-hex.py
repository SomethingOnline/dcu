#!/usr/bin/env python3

base = 16

n = int(input())
output = ""

while 0 < n:
    output = str(n % base) + output
    n = n // base

i = 0
while i < len(output):
    print(output[0:2])
    print(output[2:len(output)])
    print("end")
    i += 1
