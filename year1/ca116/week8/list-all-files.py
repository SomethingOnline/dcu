#!/usr/bin/env python3

import os
directories = ["."]
while 0 < len(directories):
    directory = directories.pop()
    entries = os.listdir(directory)
    i = 0
    while i < len(entries):
        entry = directory + "/" + entries[i]
        if os.path.isfile(entry):
            print(entry)
        if os.path.isdir(entry):
            directories.append(entry)
        i += 1
