#!/bin/usr/env python3

def filter_star(dict, int):
    newDict = {}
    for k, v in dict.items():
        if len(v) == int:
            newDict[k] = v
    if newDict:
        print(newDict)
    else:
        print("No result found!")

filter_star({
  'Luxury Chocolates': '*****',
  'Tasty Chocolates': '****',
  'Big Chocolates': '*****',
  'Generic Chocolates': '***'
}, 4)


filter_star({
  'Luxury Chocolates': '*****',
  'Tasty Chocolates': '****',
  'Big Chocolates': '*****',
  'Generic Chocolates': '***'
}, 2)

