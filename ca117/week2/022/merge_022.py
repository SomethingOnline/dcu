#!/usr/bin/env python3

import sys
filenames = sys.argv[1:]
file1 = filenames[0]
file2 = filenames[1]
list1 = []
list2 = []

with open(file1,"r") as file_a:
    fileAin = file_a.readlines()
for i in range(len(fileAin)):
    list1.append(fileAin[i].strip())

with open(file2, "r") as file_b:
    fileBin = file_b.readlines()
for i in range(len(fileBin)):
    list2.append(fileBin[i].strip())

i = 0
while i < len(list1) and i < len(list2):
    print(list1[i])
    print(list2[i])
    i += 1














# i = 0
# while i < len(filenames):
#     if i == 0:
#         with open(filenames[i],"r") as f:
#             for line in f:
#                 line = line.strip()
#             print(line)
#         i += 1
#     elif i == 1:
#         with open(filenames[i],"r") as f:
#             for line in f:
#                 line = line.strip()
#             print(line)
#         i -= 1
