#!/usr/bin/env python3

class MP3Track(object):
    def __init__(self, title, duration):
        self.title = title
        self.duration = duration
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'Duration: {self.duration}')
        return '\n'.join(output)
    
class MP3Collection(object):
    def __init__(self):
        self.dict = {}
    def add(self, MP3):
        self.dict[MP3.title] = MP3
    def remove(self, title):
        if title in self.dict:
            del(self.dict[title])
    def lookup(self, title):
        if title in self.dict:
            return self.dict[title]
