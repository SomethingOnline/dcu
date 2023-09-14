#!/usr/bin/env python3

class Patient(object):
    def __init__(self, name, age, doctor, medications=None):
        self.name = name
        self.age = age
        self.doctor = doctor
        if medications == None:
            self.medications = []
        else:
            self.medications = medications
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'Age: {self.age}')
        output.append(f'Medications: {", ".join(self.medications)}')
        output.append(f'Doctor: {self.doctor}')
        return '\n'.join(output)
from patient_v2_131 import Patient

def main():
    p1 = Patient('Mary', 34, 'James Kildare', ['aspirin'])
    p2 = Patient('Wendy', 40, 'Gregory House', ['penicillin', 'nexium'])

    print(p1)
    print(p2)

if __name__ == '__main__':
    main()