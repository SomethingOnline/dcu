#!/usr/bin/env python3

class MP3Track(object):
    def __init__(self, title, duration, namesList = None):
        self.title = title
        self.duration = duration
        if namesList == None:
            self.namesList = []
        else:
            self.namesList = namesList
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'By: {", ".join(self.namesList)}')
        output.append(f'Duration: {self.duration}')
        return '\n'.join(output)