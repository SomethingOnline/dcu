#!/usr/bin/env python3

vowels = 'aeiouAEIOU'
def move_vow(string):
    string = string.strip()
    firstlist = []
    secondlist = []
    for char in string:
        if char in vowels:
            firstlist.append(char)
        else:
            secondlist.append(char)
    return(("".join(firstlist + secondlist)))

print(move_vow('This is DCU!'))
