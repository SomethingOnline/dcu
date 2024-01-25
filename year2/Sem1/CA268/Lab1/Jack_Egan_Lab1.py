

#   Q1
def q1_sum(matrix):
    sum = 0
    for line in matrix:
        for num in line:
            if num % 2 == 0:
                sum += num
    print(sum)

# Q2
vowels = 'aeiouAEIOU'
def move_vow(string):
    string = string.strip()
    firstlist = []
    secondlist = []
    for char in string:
        if char in vowels:
            firstlist.append(char)
        else:
            secondlist.append(char)
    print(("".join(firstlist + secondlist)))

# Q3
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

# Q4
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
            
# Q5
def histogram(list, character):
    histogramList = []
    for line in list:
        histogramList.append(character * line)
    print("\n".join(histogramList))

# Q6
def filter_star(dict, int):
    newDict = {}
    for k, v in dict.items():
        if len(v) == int:
            newDict[k] = v
    if newDict:
        print(newDict)
    else:
        print("No result found!")