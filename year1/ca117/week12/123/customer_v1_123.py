#!/usr/bin/env python3

class Customer(object):
    def __init__(self, name, number, balance=0.00):
        self.name = name
        self.number = number
        self.balance = balance
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'Number: {self.number}')
        output.append(f'Balance: {self.balance:02.02f}')
        return '\n'.join(output)
from customer_v1_123 import Customer

def main():
    c1 = Customer('Alan Wren', 12434655, 100.00)
    c2 = Customer('John Squire', 54211677, 200.22)
    c3 = Customer('Ian Brown', 89766121)

    assert(c1.name == 'Alan Wren')
    assert(c1.number == 12434655)
    assert(c1.balance == 100.00)

    print(c1)
    print(c2)
    print(c3)

if __name__ == '__main__':
    main()