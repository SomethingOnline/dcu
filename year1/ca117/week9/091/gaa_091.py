#!/usr/bin/env python3

class Score(object):

    def __init__(self, goals=0, points=0):
        self.goals = goals
        self.points = points
    def __str__(self):
        return f'{self.goals:d} goal(s) and {self.points:d} point(s)'