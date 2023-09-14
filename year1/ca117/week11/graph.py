
class Graph(object):

    def __init__(self, V):
        self.V = V
        self.adj = {}           # vertices not connected to anything yet, map vertices to others
        for v in range(0, V):
            self.adj[v] = []            # creates vertices 0-6, all not connected to anything yet
                                        # output = {0: [], 1: [], 2: [], 3: [], 4: [], 5: [], 6: []}
    def add_edge(self, v, w):
        self.adj[v].append(w)
        self.adj[w].append(v)           # if v connected to w , w connected to v

    def get_degree(self, V):
        return len(self.adj[V])
    
    def max_degree(self):
        degress = [self.get_degree(v) for v in self.adj]
        return max(degress)
    def avg_degree(self):
        degress = [self.get_degree(v) for v in self.adj]
        total = sum(degress) / len(degress)
        return total


with open('graph_input_00_112.txt', 'r') as f:
    V = int(f.readline().strip())
    g = Graph(V)
    print(g.adj)
    for line in f:
        v, w = [int(t) for t in line.strip().split()]
        g.add_edge(v, w)
    print(g.adj)
for i in range(0, 7):
    print(g.get_degree(i))
print(g.max_degree())
print(g.avg_degree())