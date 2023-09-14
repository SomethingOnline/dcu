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

