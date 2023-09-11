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