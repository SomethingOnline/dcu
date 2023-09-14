#!/usr/bin/env python3

class Customer(object):
    def __init__(self, name, number, balance=0.00):
        self.name = name
        self.number = number
        self.balance = balance
    def lodge(self, amount):
        self.balance += amount
    def withdraw(self, amount):
        if self.balance - amount >= 0:
            self.balance -= amount
        else:
            pass
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'Number: {self.number}')
        output.append(f'Balance: {self.balance}')
        return '\n'.join(output)

from customer_v2_123 import Customer

def main():
    c1 = Customer('Alan Wren', 12434655, 100.00)

    c1.lodge(1.11)
    print(c1)

    c1.withdraw(200)
    print(c1)

    c1.withdraw(2)
    print(c1)

if __name__ == '__main__':
    main()