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

def sort_onNumber(item):
    return item.number

class Bank(object):
    def __init__(self):
        self.dict = {}
    def add(self, customer):
        self.dict[customer.number] = customer
    def remove(self, number):
        del(self.dict[number])
    def lookup(self, number):
        if number in self.dict:
            return self.dict[number]
        else:
            return None
    def get_total_funds(self):
        funds = []
        for v in sorted(self.dict.values(), key=sort_onNumber):
            funds.append(v.balance)
        return sum(funds)
    
    def __str__(self):
        output = []
        for v in sorted(self.dict.values(), key=sort_onNumber):
            output.append(f'{v}')
        output.append(f'Total funds: {self.get_total_funds()}')
        return '\n'.join(output)

from bank_v2_123 import Customer, Bank

def main():
    c1 = Customer('Alan Wren', 12434655, 100.00)
    c2 = Customer('John Squire', 54211677, 200.22)
    c3 = Customer('Ian Brown', 10145211, 1.50)

    b = Bank()

    b.add(c1)
    b.add(c2)
    b.add(c3)

    print(b)

if __name__ == '__main__':
    main()