#!/usr/bin/env python3

class BankAccount(object):

    def set_attributes(self, name, number, balance):
        self.name = name
        self.number = number
        self.balance = int(balance)
    
    def print_attributes(self):
        print(f'Name: {self.name}')
        print(f'Account number: {self.number}')
        print(f'Balance: {self.balance}.00')
    
    def deposit(self , deposit):
        self.deposit = int(deposit)
        self.balance += self.deposit