#!/usr/bin/env python3

class Contact(object):

    def __init__(self, name, phone, email):
        self.name = name
        self.phone = phone
        self.email = email
    def __str__(self):
        return '{} {} {}'.format(self.name, self.phone, self.email)
    
class Contactlist(object):

    def __init__(self):
        self.d = {}
    def add(self, contact):
        self.d[contact.name] = contact
    def remove(self, name):
        if name in self.d:
            del(self.d[name])
        else:
            pass
    def get(self, name):
        if name in self.d:
            return self.d[name]
        else:
            return None
    def __str__(self):
        lines = []
        lines.append('Contact list')
        lines.append('------------')
        for k, v in sorted(self.d.items()):
            lines.append('{}'.format(v))
        return '\n'.join(lines)
        
