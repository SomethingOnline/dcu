#!/usr/bin/env python3

import sys
filename = sys.argv[1]

grades = []
names = []
try:
    with open(filename, "r") as f_out:
        for line in f_out:
            line = line.strip()
            i = 0
            while i < len(line) and not line[i].isnumeric():
                i += 1
            grade = line[:i + 2]
            name = line[i + 2:].strip()
            grades.append(grade)
            names.append(name)
        i = 0
        biggest = grades[-1]
        while i < len(grades) and grades[i] < biggest:
            i += 1
        print("Best student:", names[i])
        print("Best mark:", grades[i])
except ValueError:
    print(f"The file {filename} could not be opened.")