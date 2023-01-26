#!/usr/bin/env python3
import sys
filename = sys.argv[1]

grades = []
names = []
beststudents = []
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
        largest = grades[i]
        i = 0
        while i < len(grades):
            if grades[i] == largest:
                beststudents.append(names[i])
            i += 1
except ValueError:
    print(f"The file {filename} could not be opened.")

beststudents = ", ".join(beststudents)
print(f"Best student(s): {beststudents}")
print(f"Best mark: {int(largest)}")