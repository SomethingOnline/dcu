#!/usr/bin/env python3

class Student(object):

    def __init__(self, name, sid, modlist=None):
        self.name = name
        self.sid = sid
        if modlist == None:
            self.modlist = []
        else:
            self.modlist = modlist
    
    def average_mark(self):
        nums = []
        for i in self.modlist:
            nums.append(int(i[1]))
        t = 0
        for d in nums:
            t += d
        return round(t / len(self.modlist))
    def get_modules(self):
        modules = []
        for i in self.modlist:
            modules.append(i[0])
        return sorted(modules)
    
    def __gt__(self, other):
        return self.average_mark() > other.average_mark()
    def __lt__(self, other):
        return self.average_mark() < other.average_mark()
    def __eq__(self, other):
        return self.average_mark() == other.average_mark()
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.sid}')
        output.append(f'Modules: {", ".join(self.get_modules())}')
        output.append(f'Average mark: {self.average_mark()}')
        return '\n'.join(output)

class Classlist(object):

    def __init__(self, dict=None):
        if dict == None:
            self.dict = {}
        else:
            self.dict = dict
    def add(self, student):
        self.dict[student.sid] = student
    def __str__(self):
        output = []
        for v in sorted(self.dict.values(), reverse=True):
            output.append(f'{v}')
        return '\n'.join(output)
    