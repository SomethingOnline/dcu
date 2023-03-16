#!/usr/bin/env python3

class Point(object):

    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def midpoint(self, other):
        x, y = (self.x + other.x) / 2, (self.y + other.y) / 2
        return Point(x, y)
    def __str__(self):
        return f'({self.x:.1f}, {self.y:.1f})'