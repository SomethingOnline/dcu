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
class Ward(object):
    def __init__(self):
        self.dict = {}
    def add(self, patient):
        self.dict[patient.name] = patient
    def remove(self, name):
        if name in self.dict:
            del(self.dict[name])
    def get_patients_by_med(self, medicine):
        list = []
        for v in self.dict.values():
            if medicine in v.medications:
                list.append(v)
        return list
    def lookup(self, name):
        if name in self.dict:
            return self.dict[name]
        else:
            return None

from ward_v2_131 import Patient, Ward

def main():
    p1 = Patient('Mary', 34, 'James Kildare', ['aspirin'])
    p2 = Patient('Wendy', 40, 'Gregory House', ['penicillin', 'nexium'])
    p3 = Patient('Sam', 42, 'Gregory House', ['nexium'])

    w = Ward()
    w.add(p1)
    w.add(p2)
    w.add(p3)

    patients = w.get_patients_by_med('nexium')
    assert(isinstance(patients, list))
    assert(len(patients) == 2)
    assert(p2 in patients)
    assert(p3 in patients)

if __name__ == '__main__':
    main()