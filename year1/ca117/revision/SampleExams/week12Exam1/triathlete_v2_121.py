#!/usr/bin/env python3

class Triathlete(object):
    def __init__(self, name, tid):
        self.name = name
        self.tid = tid
        self.dict = {}
    def add_time(self, discipline, time):
        if discipline not in self.dict:
            self.dict[discipline] = time
    def get_time(self, discipline):
        return self.dict[discipline]
    def get_race_time(self):
        return sum(self.dict.values())
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.tid}')
        output.append(f'Race time: {self.get_race_time()}')
        return '\n'.join(output)
