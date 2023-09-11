#!/usr/bin/env python3

import sys
import calendar
days = {
    0: "Monday",
    1: "Tuesday",
    2: "Wednesday",
    3: "Thursday",
    4: "Friday",
    5: "Saturday",
    6: "Sunday",
}
endings = {
    "Monday": "Monday’s child is fair of face",
    "Tuesday": "Tuesday’s child is full of grace",
    "Wednesday": "Wednesday’s child is full of woe",
    "Thursday": "Thursday’s child has far to go",
    "Friday": "Friday’s child is loving and giving",
    "Saturday": "Saturday’s child works hard for a living", 
    "Sunday": "Sunday’s child is fair and wise and good in every way"
}


def birthday(line):
    day, month, year = line.split()
    numDay = calendar.weekday(year, month, day)
    return numDay

for line in sys.stdin:
    line = line.strip()
    print(birthday(line))