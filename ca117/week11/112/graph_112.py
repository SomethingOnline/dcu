#!/usr/bin/env python3

class Graph(object):

    def __init__(self, V):
        self.V = V
        self.adj = {}
        for i in range(0, V):
            self.adj[i] = []
    def addEdge(self, v, w):
        self.adj[v].append(w)
        self.adj[w].append(v)
    def degree(self, v):
        return len(self.adj[v])
    def maxDegree(self):
        lens = [self.degree(i) for i in self.adj]
        return max(lens)
    def avgDegree(self):
        lens = [self.degree(i) for i in self.adj]
        return sum(lens) / len(lens)

import sys

from graph_112 import Graph

def main():

    with open('graph_input_00_112.txt', 'r') as f:

        V = int(f.readline().strip())

        g = Graph(V)

        for line in f:
            v, w = [int(t) for t in line.strip().split()]
            g.addEdge(v, w)

    for v in range(g.V):
        print('Vertex {} connects to {}'.format(v, g.adj[v]))
    for v in range(V):
        print('Degree of vertex {} is {}'.format(v, g.degree(v)))
    print('Maximum degree is {}'.format(g.maxDegree()))
    print('Average degree is {:.2f}'.format(g.avgDegree()))

if __name__ == '__main__':
    main()