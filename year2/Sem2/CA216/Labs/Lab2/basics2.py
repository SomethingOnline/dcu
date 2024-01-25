from multiprocessing import *
def sayHi():
    print("Hi from process", current_process().pid)

def sayHi2(n):
    print("Hi", n, "from process", current_process().pid, "(main process)")

    
def manyGreetings():
    print("Hi from process", current_process().pid, "(main process)")
    name = "Jimmy"
    p1 = Process(target=sayHi2, args=(name,))
    p2 = Process(target=sayHi2, args=(name,))
    p3 = Process(target=sayHi2, args=(name,))

    p1.start()
    p2.start()
    p3.start()

def manyGreetings2():
    name = input("Enter ur name: ")
    numProcesses = int(input("Please enter the num processes: "))


    for i in range(numProcesses):
        (Process(target=sayHi2, args=(name,))).start()
    
def procEx2():
    print("HI from process", current_process().pid, "(parent process)")
    
    p1 = Process(target=sayHi, args=())
    p2 = Process(target=sayHi, args=())
    p3 = Process(target=sayHi, args=())
    
    p1.start()
    p2.start()
    p3.start()
manyGreetings2()
    
