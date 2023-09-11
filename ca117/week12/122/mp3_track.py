#!/usr/bin/env python3


class MP3Track(object):

    def __init__(self, title, duration, artistsList=None):
        self.title = title
        self.duration = duration
        if artistsList == None:
            self.artistsList = []

    
    def get_mins_and_seconds(self):
        mins = int(self.duration) // 60
        seconds = int(self.duration) % 60
        return (f'Time: {mins:02d}:{seconds:02d}')
    
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'Duration: {self.duration}')
        output.append(f"By: {', '.join(self.artistsList)}")
        output.append(self.get_mins_and_seconds())
        return '\n'.join(output)


class MP3Collection(object):

    def __init__(self):
        self.d = {}
    def add(self, mp3):
        self.d[mp3.title] = mp3
    def remove(self, title):
        if title in self.d:
            del(self.d[title])
    def lookup(self, title):
        if title in self.d:
            return self.d[title]
        return None
    # adding 2 objects together
    def __add__(self, other):
        c = MP3Collection()
        for mp3 in self.d.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.artistsList[:]))
        for mp3 in other.d.values():
            c.add(MP3Track(mp3.title, mp3.duration, mp3.artistsList[:]))
        return c

t1 = MP3Track('Fools Gold', 604)
print(t1)
