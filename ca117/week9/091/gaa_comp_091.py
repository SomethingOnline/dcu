#!/usr/bin/env python3

class Score(object):

    def __init__(self, goals=0, points=0):
        self.goals = goals
        self.points = points
    def score2points(self):
        return (self.goals * 3) + self.points
    def __lt__(self, other):
        return self.score2points() < other.score2points()
    def __gt__(self, other):
        return self.score2points() > other.score2points()
    def __ge__(self, other):
        return self.score2points() >= other.score2points()
    def __le__(self, other):
        return self.score2points() <= other.score2points()
    def __eq__(self, other):
        return self.score2points() == other.score2points()
    def __str__(self):
        return f'{self.goals:d} goal(s) and {self.points:d} point(s)'
    