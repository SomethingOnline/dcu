#!/bin/usr/env python3

def filter_star(dict, int):
    for k, v in dict.items():
        if v.count("*") == int:
            print(f'{k}, {v}')
            break
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
}, 2) ➞ No result found!


