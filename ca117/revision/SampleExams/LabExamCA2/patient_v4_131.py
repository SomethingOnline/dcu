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
        self.vitals = {}
    def add_medication(self, medication):
        if medication not in self.medications:
           self.medications.append(medication)
    def record_vital(self, vital, rate):
        self.vitals[vital] = rate
    def get_vital(self, vital):
        if vital in self.vitals:
            return self.vitals[vital]
        else:
            return 'N/A'
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'Age: {self.age}')
        output.append(f'Medications: {", ".join(self.medications)}')
        output.append(f'Doctor: {self.doctor}')
        return '\n'.join(output)

from patient_v4_131 import Patient

def main():
    p1 = Patient('Mary', 34, 'James Kildare')
    p2 = Patient('Wendy', 40, 'Gregory House')

    p1.record_vital('pulse', 78)
    p1.record_vital('breathing', 15)
    print(p1.get_vital('pulse'))
    p1.record_vital('pulse', 81)
    print(p1.get_vital('pulse'))

    p2.record_vital('temperature', 37)
    print(p2.get_vital('breathing'))

if __name__ == '__main__':
    main()