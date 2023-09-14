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
from patient_v1_131 import Patient

def main():
    p1 = Patient('Mary', 34, 'James Kildare')
    p2 = Patient('Wendy', 40, 'Gregory House')

    assert(isinstance(p1, Patient))
    assert(p1.name == 'Mary')
    assert(p1.age == 34)
    assert(p1.doctor == 'James Kildare')

    print(p1)
    print(p2)

if __name__ == '__main__':
    main()