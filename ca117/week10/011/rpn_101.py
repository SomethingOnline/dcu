#!/usr/bin/env python3
from math import sqrt

class Stack(object):
    def __init__(self):
        self.l = []
    def push(self, e):
        self.l.append(e)
    def pop(self):
        return self.l.pop()
    def top(self):
        return self.l[-1]
    def is_empty(self):
        return len(self.l) == 0
    def __len__(self):
        return len(self.l)
    
# For 1 number needed
binops = {'+': float.__add__,
          '-': float.__sub__,
          '*': float.__mul__,
          '/': float.__truediv__}
# For 1 number needed 
uniops = {'n': float.__neg__,
          'r': sqrt}

# # To add 3 and 5 we can do something like this...
# print(binops['+'](3.0, 5.0))

# # To calcualte the square root of 9 we can do something like this...
# print(uniops['r'](9.0))

def calculator(line):
    s = Stack()
    for i in line.split():
        if i.isnumeric():
            s.push(float(i))
        elif i in binops:
            n1 = s.pop()
            n2 = s.pop()
            s.push(binops[i](n2, n1))
        elif i in uniops:
            s.push(uniops[i](s.pop()))
        else:
            s.push(float(i))
    return s.pop()
        