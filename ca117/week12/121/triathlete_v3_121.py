#!/usr/bin/env python3#

class Triathlete(object):

    def __init__(self, name, tid):
        self.name = name
        self.tid = tid
        self.d = {}

    def add_time(self, sport, time):
        self.d[sport] = time

    def get_time(self, sport):
        return self.d[sport]
    
    def total_time(self):
        return sum(self.d.values())
    
    def __eq__(self, other):
        return self.total_time() == other.total_time()
    def __lt__(self, other):
        return self.total_time() < other.total_time()
    def __gt__(self, other):
        return self.total_time() > other.total_time()
    
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.tid}')
        output.append(f'Race time: {self.total_time()}')
        return '\n'.join(output)