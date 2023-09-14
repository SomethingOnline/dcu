#!/usr/bin/env python3

import sys
import calendar
lines = sys.stdin.readlines()
weeks = {
    1:"You were born on a Monday and Monday's child is fair of face.",
    2:"You were born on a Tuesday and Tuesday's child is full of grace.",
    3:"You were born on a Wednesday and Wednesday's child is full of woe.",
    4:"You were born on a Thursday and Thursday's child has far to go.",
    5:"You were born on a Friday and Friday's child is loving and giving.",
    6:"You were born on a Saturday and Saturday's child works hard for a living.",
    7:"You were born on a Sunday and Sunday's child is far and wise and good in every way."
}

for line in lines:
    line = line.strip().split(" ")
    day = int(line[0])
    month = int(line[1])
    year = int(line[-1])
    date = calendar.weekday(year, month, day) + 1
    print(weeks[date])
