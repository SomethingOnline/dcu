#!/usr/bin/env python3

class Student(object):

    def set_attributes(self, sid, name, modlist):
        self.sid = sid
        self.name = name
        self.modlist = modlist
    
    def print_attributes(self):
        print(f'ID: {self.sid}')
        print(f'Name: {self.name}')
        print(f'Modules: {", ".join(self.modlist)}')

    def add_module(self, NewModule):
        self.newModule = NewModule
        if self.newModule not in self.modlist:
            self.modlist.append(self.newModule)

    
    def del_module(self, delModule):
        self.del_module = delModule
        if self.del_module in self.modlist:
            self.modlist.remove(self.del_module)
