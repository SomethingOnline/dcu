#!/usr/bin/env python3
import sys
lines = []
for line in sys.stdin:
    lines.append(line.strip())

def ShortestAllVowels(list):
    vowels = ['a', 'e', 'i', 'o', 'u']
    allvowels = []
    for line in list:
        line = line.strip()
        if line.count('a') >= 1 and line.count('e') >= 1 and line.count('i') >= 1 and line.count('o') >= 1 and line.count('u') >= 1:
            allvowels.append(line)
    return min(allvowels, key=len)

print(f'Shortest word containing all vowels: {ShortestAllVowels(lines)}')
iaryList = [line.strip() for line in lines if line.endswith('iary')]
print(f'Words ending in iary: {len(iaryList)}')

maxE = max([line.lower().count('e') for line in lines])
print(f"Words with most e's: {[line for line in lines if line.count('e') == maxE]}")