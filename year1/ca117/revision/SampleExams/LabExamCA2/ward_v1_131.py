#!/usr/bin/env python3

class Patient(object):
    def __init__(self, name, age, doctor):
        self.name = name
        self.age = age
        self.doctor = doctor
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'Age: {self.age}')
        output.append(f'Doctor: {self.doctor}')
        return '\n'.join(output)
    
class Ward(object):
    def __init__(self):
        self.dict = {}
    def add(self, patient):
        self.dict[patient.name] = patient
    def remove(self, name):
        if name in self.dict:
            del(self.dict[name])
    def lookup(self, name):
        if name in self.dict:
            return self.dict[name]
        else:
            return None

from ward_v1_131 import Patient, Ward

def main():
    p1 = Patient('Mary', 34, 'James Kildare')
    p2 = Patient('Wendy', 40, 'Gregory House')

    w = Ward()

    w.add(p1)
    w.add(p2)

    p = w.lookup('Mary')
    assert(isinstance(p, Patient))
    assert(p.name == 'Mary')
    assert(p.age == 34)

    w.remove('Mary')
    p = w.lookup('Mary')
    assert(p is None)

if __name__ == '__main__':
    main()