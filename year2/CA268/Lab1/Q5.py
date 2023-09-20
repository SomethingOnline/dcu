#!/usr/bin/env python3

def histogram(list, character):
    histogramList = []
    for line in list:
        histogramList.append(character * line)
    print("\n".join(histogramList))


(histogram([6, 2, 15 , 3, 20 , 5],'='))