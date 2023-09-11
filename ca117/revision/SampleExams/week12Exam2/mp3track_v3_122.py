#!/usr/bin/env python3


class MP3Track(object):
    def __init__(self, title, duration, artistList = None):
        self.title = title
        self.duration = duration
        if artistList == None:
            self.artistList = []
        else:
            self.artistList = artistList
    def get_mins_and_seconds(self):
        mins = self.duration // 60
        seconds = self.duration % 60
        return f'{mins:01d}:{seconds:02d}'
    def __str__(self):
        output = []
        output.append(f'Title: {self.title}')
        output.append(f'By: {", ".join(self.artistList)}')
        output.append(f'Duration: {self.get_mins_and_seconds()}')
        return '\n'.join(output)
