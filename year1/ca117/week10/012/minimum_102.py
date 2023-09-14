#!/usr/bin/env python3

# find the answer in terms of the cases before
# if theres one item in list , return item
# else check if first item is smaller than anything else
# if it is return it
# if not check rest of list
def minimum(list=None):
    if len(list) == 1:
        return list[0]
    else:
        if list[0] < minimum(list[1:]):
            return list[0]
        else:
            return minimum(list[1:])