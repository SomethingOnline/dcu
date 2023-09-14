#!/usr/bin/env python3

class Triathlete(object):
    def __init__(self, name, tid):
        self.name = name
        self.tid = tid
        self.dict = {}
    def add_time(self, discipline, time):
        if discipline not in self.dict:
            self.dict[discipline] = time
    def get_time(self, discipline):
        return self.dict[discipline]
    def get_race_time(self):
        return sum(self.dict.values())
    def __eq__(self, other):
        return self.get_race_time() == other.get_race_time()
    def __lt__(self, other):
        return self.get_race_time() < other.get_race_time()
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.tid}')
        output.append(f'Race time: {self.get_race_time()}')
        return '\n'.join(output)

def sort_onName(item):
    return item.name
def sort_onTime(item):
    return item.get_race_time()

class Triathlon(object):
    def __init__(self):
        self.dict = {}
    def add(self, triathlete):
        self.dict[triathlete.tid] = triathlete
    def remove(self, tid):
        if tid in self.dict:
            del(self.dict[tid])
    def lookup(self, tid):
        if tid in self.dict:
            return self.dict[tid]
        else:
            return None
    def best(self):
        for v in sorted(self.dict.values(), key=sort_onTime):
            return f'{v}'
    def worst(self):
        for v in sorted(self.dict.values(), key=sort_onTime, reverse=True):
            return f'{v}'
    def __str__(self):
        output = []
        for v in sorted(self.dict.values(), key=sort_onName):
            output.append(f'{v}')
        return '\n'.join(output)
    

from triathlon_v3_121 import Triathlete, Triathlon

def main():

    tn = Triathlon()
    t1 = Triathlete('Ian Brown', 21)
    t2 = Triathlete('John Squire', 22)
    t3 = Triathlete('Alan Wren', 23)

    t1.add_time('swim', 100)
    t1.add_time('cycle', 120)
    t1.add_time('run', 150)

    t2.add_time('swim', 300)
    t2.add_time('cycle', 100)
    t2.add_time('run', 200)

    t3.add_time('swim', 50)
    t3.add_time('cycle', 20)
    t3.add_time('run', 10)

    tn.add(t1)
    tn.add(t2)
    tn.add(t3)

    print(tn.best())
    print(tn.worst())

if __name__ == '__main__':
    main()