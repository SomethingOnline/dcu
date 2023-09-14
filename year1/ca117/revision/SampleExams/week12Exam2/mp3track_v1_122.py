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