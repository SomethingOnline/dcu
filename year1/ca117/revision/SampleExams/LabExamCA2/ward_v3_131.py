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
    def add_medication(self, medication):
        if medication not in self.medications:
           self.medications.append(medication)
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
    def get_most_common_meds(self):
        list = []
        for v in self.dict.values():
            for i in v.medications:
                list.append(len(self.get_patients_by_med(i)))
        Most = max(list)
        mostCommon = []
        for v in self.dict.values():
            for i in v.medications:
                if len(self.get_patients_by_med(i)) == Most and i not in mostCommon:
                    mostCommon.append(i)
        return mostCommon
    def get_least_common_meds(self):
        list = []
        for v in self.dict.values():
            for i in v.medications:
                list.append(len(self.get_patients_by_med(i)))
        Least = min(list)
        leastCommon = []
        for v in self.dict.values():
            for i in v.medications:
                if len(self.get_patients_by_med(i)) == Least and i not in leastCommon:
                    leastCommon.append(i)
        return leastCommon
    def lookup(self, name):
        if name in self.dict:
            return self.dict[name]
        else:
            return None
        
from ward_v3_131 import Patient, Ward

def main():
    p1 = Patient('Mary', 34, 'James Kildare', ['aspirin'])
    p2 = Patient('Wendy', 40, 'Gregory House', ['penicillin', 'nexium'])
    p3 = Patient('Sam', 42, 'Gregory House', ['nexium'])

    w = Ward()
    w.add(p1)
    w.add(p2)
    w.add(p3)

    meds = w.get_least_common_meds()
    assert(isinstance(meds, list))
    assert(len(meds) == 2)
    assert('aspirin' in meds)
    assert('penicillin' in meds)

    meds = w.get_most_common_meds()
    assert(isinstance(meds, list))
    assert(len(meds) == 1)
    assert('nexium' in meds)

if __name__ == '__main__':
    main()