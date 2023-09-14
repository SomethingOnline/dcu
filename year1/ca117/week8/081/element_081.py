#!/usr/bin/env python3


class Element(object):
    
    def set_attributes(self, number, name, symbol, bp):
        self.number = number
        self.name = name
        self.symbol = symbol
        self.bp = bp
    def print_attributes(self):
        print(f'Number: {self.number}')
        print(f'Name: {self.name}')
        print(f'Symbol: {self.symbol}')
        print(f'Boiling point: {self.bp} K')
