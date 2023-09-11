import sys

pattern = sys.stdin.readline().strip()
lines = sys.stdin.readlines()

indices = []
output = []

for i, char in enumerate(pattern):
    if char == '-':
        indices.append(i)

for line in lines:
    copy = line[:]
    line = list(line.strip())
    for i in indices:
        try:
            line[i] = '-'
        except IndexError:
            pass
    if ''.join(line) == pattern:
        output.append(copy.strip())

if len(output) > 0:
    print(', '.join(output))