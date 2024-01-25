from multiprocessing import *
import time

# def greet(q):
#     print("(child process) Waiting for name...")
#     name = q.get()
#     print("(Child process) Well, hi ", name)
# def sendName():
#     q = Queue()

#     p1 = Process(target=greet, args=(q,))
#     p1.start()

#     time.sleep(5)
#     print("(Parent process) Ok, I'll send the name")
#     q.put("Jimmy")
# sendName()


def greet2(q):
    for i in range(5):
        print("(child process) Waiting for name...")
        name = q.get()
        print("(Child process) Well, hi ", name)
def sendName2():
    q = Queue()

    p1 = Process(target=greet2, args=(q,))
    p1.start()

   
    for i in range(5):
        time.sleep()
        print("(Parent process) Ok, I'll send the name")
        q.put("Jimmy" + str(i + 1))
sendName2()