#!/usr/bin/env python3

class Test:
    def __init__(self, subject_name, correct_answers, pasing_mark=0):
        self.subject_name = subject_name
        self.correct_answers = correct_answers
        self.passing_mark = pasing_mark


paper1 = Test('Maths', ['1A', '2C', '3D', '4A', '5A'], '60%')
paper2 = Test('Chemistry', ['1C', '2C', '3D', '4A'], '75%')
paper3 = Test('Computing', ['1D', '2C', '3C', '4B', '5D', '6C', '7A'], '75%')

class Student(Test):
    def __init__(self, name):
        self.name = name
    def take_test(self, paper, studentAns):
        correct = paper.correct_answers
        count = 0
        
        