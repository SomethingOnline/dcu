#!/usr/bin/env python3#

class Triathlete(object):

    def __init__(self, name, tid):
        self.name = name
        self.tid = tid
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.tid}')
        return '\n'.join(output)

class Triathlon(object):
    def __init__(self):
        self.d = {}
    def add(self, triathlete):
        self.d[triathlete.tid] = triathlete
    def remove(self, tid):
        del (self.d[tid])
    def lookup(self, tid):
        if tid in self.d:
            return self.d[tid]
        return None
    
