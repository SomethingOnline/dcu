#!/usr/bin/env python3


# solve for how many islands are in a graph (groups of vertices connected to each other)
# DFS

class Graph(object):
    def __init__(self, V):
        self.V = V
        self.adj = {}
        for i in range(V):
            self.adj[V] = []
    def addEdge(self, v, w):
        self.adj[v].append(w)
        self.adj[w].apppend(v)

def search(v, visited, adj):
    visited[v] = True
    for w in adj[v]:
        if not visited[w]:
            search(w, visited, g.adj)                   # DFS (V, visited, start)


lines = ['10', '0 1', '0 2', '0 3', '0 4', '2 3', '5 6', '5 7', '6 7', '7 8']

V = int(lines[0])
g = Graph(V)
for line in lines[1:]:
    v, w = [int(t) for t in lines.strip().split()]
    g.addEdge(v, w)

islands = 0
visited = [False] * V
for v in range(V):
    if not visited[v]:
        islands += 1
        search(v, visited, g.adj)               # g.adj is telling u where u can go

print(islands)          # 3, 3 different groups of vertices connected to each other that dont link with any others