#!/usr/bin/env python3

class Triathlete(object):
    def __init__(self, name, tid):
        self.name = name
        self.tid = tid
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.tid}')
        return '\n'.join(output)

def sort_on(item):
    return item.name

class Triathlon(object):
    def __init__(self):
        self.dict = {}
    def add(self, triathlete):
        self.dict[triathlete.tid] = triathlete
    def remove(self, tid):
        if tid in self.dict:
            del(self.dict[tid])
    def lookup(self, tid):
        if tid in self.dict:
            return self.dict[tid]
        else:
            return None
    def __str__(self):
        output = []
        for v in sorted(self.dict.values(), key=sort_on):
            output.append(f'{v}')
        return '\n'.join(output)
