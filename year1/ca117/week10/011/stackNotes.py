

class Stack(object):
    def __init__(self):
        self.l = []
    def push(self, e):
        self.l.append(e)
    def top(self):
        return self.l[-1]
    def pop(self):
        return self.l.pop()
    def is_empty(self):
        return len(self.l) == 0
    
    # st = stack()
    # call len(st) to get amount of elements
    def __len__(self):
        return len(self.l)