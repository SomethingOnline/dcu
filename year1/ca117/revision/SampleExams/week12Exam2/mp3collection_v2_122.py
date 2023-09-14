#!/usr/bin/env python3

class MP3Track(object):
    def __init__(self, title, duration, artistList = None):
        self.title = title
        self.duration = duration
        if artistList == None:
            self.artistList = []
        else:
            self.artistList = artistList
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'By: {", ".join(self.artistList)}')
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
    def __add__(self, other):
        c = MP3Collection()
        for mp3 in self.dict.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.artistList))
        for mp3 in other.dict.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.artistList))
        return c