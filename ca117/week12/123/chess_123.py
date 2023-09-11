#!/usr/bin/env python3
import sys
# 2 kings, 2 queens, 4 rooks, 4 bishops, 4 knights, 16 pawns
# each line = 6 integers ( zero or positive)
# each num correlates to above number of each piece
# print how much is needed for each num to be the full value in 1st comment

for line in sys.stdin:
    line = line.strip().split()
    ChessSet = [2, 2, 4, 4, 4, 16]
    newline = []
    for a, b in zip(line, ChessSet):
        if a != b:
            newline.append(str(int(b) - int(a)))
        else:
            newline.append('0')
    print(" ".join(newline))