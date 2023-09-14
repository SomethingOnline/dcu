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