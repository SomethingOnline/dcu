#!/usr/bin/env python3

import sys
lines = []
for line in sys.stdin:
    lines.append(line.strip())

def is_angle(word):
    angle = "angle"
    if word == angle:
        return False
    for i in word:
        if i in angle:
            word = word.replace(i, "", 1)
            angle = angle.replace(i, "", 1)
    if len(word) == 0 and len(angle) == 0:
        return True
    return False

print(f'Words containing 17 letters: {[word for word in lines if len(word) == 17]}')
print(f'Words containing 18+ letters: {[word for word in lines if len(word) >= 18]}')
print(f"Words with 4 a's: {[word for word in lines if word.lower().count('a') == 4]}")
print(f"Words with 2+ q's: {[word for word in lines if word.lower().count('q') >= 2]}")
print(f"Words containing cie: {[word for word in lines if 'cie' in word.lower()]}")
print(f"Anagrams of angle: {[word for word in lines if is_angle(word.lower())]}")