#!/usr/bin/env python3

class BankAccount(object):

    def __init__(self, balance=0):
        self.balance = balance

    def deposit(self, deposit):
        self.balance += deposit

    def withdraw(self, withdraw):
        if self.balance - withdraw >= 0:
            self.balance -= withdraw

    def __str__(self):
        return str(f'Your current balance is {self.balance:.02f} euro')