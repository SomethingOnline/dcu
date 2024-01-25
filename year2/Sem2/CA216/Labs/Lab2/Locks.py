from multiprocessing import *

# def sayHi4(lock, name):
#     lock.acquire()
#     print("Hi", name, " from process", current_process().pid)
#     lock.release()
# def manyGreetings4():
#     lock1 = Lock()
#     print("Hi from process", current_process().pid, "(main process)")

#     for i in range(10):
#         Process(target=sayHi4, args=(lock1, "p"+str(i + 1))).start()
# manyGreetings4()



letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]


def sayHi5(lock, name, letter):
    lock.acquire()
    print("Hiddy-ho! I'm worker ", name, " and today I have to dig hole", letter)
    lock.release()
def manyGreetings():
    lock1 = Lock()

    for i in range(len(letters)):
        Process(target=sayHi5, args=(lock1, letters[i], str(i))).start()
manyGreetings()