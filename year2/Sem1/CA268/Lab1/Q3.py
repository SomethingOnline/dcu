#!/usr/bin/env python3

class Memories():
    def __init__(self, **kwargs):               #keyword variable arguments     # two * = arguments passed are in dictionary construct, key=value
        self.dict = {}
        for k, v in kwargs.items():
            self.dict[k] = v
    def remember(self, attribute):
        if attribute in self.dict.keys():
            print(self.dict[attribute])
        else:
            print("False")

        
person1 = Memories(name='Tom', age=32, salary=50000)
person1.remember('salary')
person1.remember('email')