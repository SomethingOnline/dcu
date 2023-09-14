#!/usr/bin/env python3

class MP3Track(object):
    def __init__(self, title, duration, namesList = None):
        self.title = title
        self.duration = duration
        if namesList == None:
            self.namesList = []
        else:
            self.namesList = namesList
    def get_hours_and_minutes(self):
        hours = self.duration // 60
        minutes = self.duration % 60
        return f'{hours}:{minutes:02d}'
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'By: {", ".join(self.namesList)}')
        output.append(f'Duration: {self.get_hours_and_minutes()}')
        return '\n'.join(output)

class MP3Collection(object):
    def __init__(self):
        self.d = {}
    def add(self, mp3):
        self.d[mp3.title] = mp3
    def remove(self, name):
        if name in self.d:
            del(self.d[name])
    def lookup(self, name):
        if name in self.d:
            return self.d[name]
        return None
    def __add__(self, other):
        c = MP3Collection()
        for mp3 in self.d.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.namesList[:]))
        for mp3 in other.d.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.namesList[:]))
        return c