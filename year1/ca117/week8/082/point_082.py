#!/usr/bin/env python3

class Point:

    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def distance(self, p):
        return (((self.x - p.x) ** 2) + ((self.y - p.y) ** 2)) ** 0.5

    def __str__(self):
        return f'({self.x:.01f}, {self.y:.01f})'

