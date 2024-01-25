from multiprocessing import *
from random import randint
import time

def slowpoke(lock):
    time.sleep(5)
    lock.acquire()
    print("Slowpoke: Ok, im coming")
    lock.release()

def haveToWait():
    lock = Lock()
    p1 = Process(target=slowpoke, args=(lock,))
    p1.start()
    print("Waiter: any day now")

    p1.join()
    print("Waiter: Finally! Geez.")


def addTwoNumbers(x, y, q):
    q.put(int(x) + int(y))

def addTwoPar():
    q = Queue()
    x = int(input("Enter first num: "))
    y = int(input("Enter 2nd num : "))
    p1 = Process(target=addTwoNumbers, args=(x, y, q))
    p1.start()
    print("Waiting")
    p1.join()
    answer = q.get()
    print("Okay this is the answer", answer)

def addManyNumbers(numNumbers, q):
    s = 0
    for i in range(numNumbers):
        s += randint(1, 100)
    q.put(s)

def addManyPar():
    totalNumNumbers = 10000
    q = Queue()
    p1 = Process(target=addManyNumbers, args=(totalNumNumbers//2, q))
    p2 = Process(target=addManyNumbers, args=(totalNumNumbers//2, q))

    p1.start()
    p2.start()

    p1.join()
    p2.join()
    answerA = q.get()
    answerB = q.get()
    print(answerA)
    print(answerB)
    print("Sum", answerA + answerB)
addManyPar()