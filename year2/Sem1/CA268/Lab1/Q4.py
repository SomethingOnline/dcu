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
        correctAns = paper.correct_answers
        pass_mark = int(paper.passing_mark[:-1])
        student_mark = 0
        for a, b in zip(studentAns, correctAns):
            if a == b:
                student_mark += 1
        student_final_mark = student_mark / len(correctAns) * 100
        if student_final_mark < pass_mark:
            print(f'{self.name} failed the {paper.subject_name} test!')
        else:
            print(f'{self.name} passed the {paper.subject_name} test with the score {student_final_mark}%')
            

stu1 = Student('Tom')
stu1.take_test(paper2, ['1C', '2C', '3D', '4A'])

stu2 = Student('John')
stu2.take_test(paper1, ['1B', '2C', '3A', '4A', '5B'])