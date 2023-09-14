#!/usr/bin/env python3

class Point(object):

    def set_attributes(self, x , y):
        self.x = x
        self.y = y
    
    def print_attributes(self):
        print(f'x: {self.x:0.2f}')
        print(f'y: {self.y:0.2f}')
    
    def reflect(self):
        self.x = - self.x
        self.y = - self.y

