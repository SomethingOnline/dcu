#!/usr/bin/env python3

# is current char a lefty, ie is it in d.values()
# if it is remember it , ie push ( onto the stack, remember its on the left

# ( [ ] )
# stack = ( [
# on meeting a righty
# pop element currently at the top and verify the current right closes the lefty
# aka the one thats popped from the stack is matched in the dict and then get rid of it
# right = key, left = values

# return if stack is empty or not , if empty then all matches, else not.
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
    
def matcher(string):
    s = Stack()
    d = {')' : '(', 
     '}' : '{',
     ']' : '['
}
    # lefties = values
    # righties = keys
    for i in string:
        if i in d.values():
            s.push(i)
        elif i in d.keys():
            if s.is_empty() or s.pop() != d[i]:
                return False
    return s.is_empty()