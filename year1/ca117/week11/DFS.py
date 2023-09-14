
class Graph(object):

    def __init__(self, V):
        self.V = V
        self.adj = {}
        for i in range(0, V):
            self.adj[i] = []
    def addEdge(self, v, w):
        self.adj[v].append(w)
        self.adj[w].append(v)

g = Graph(7)

class DFSPaths(object):

    def __init__(self, graph, start):
        self.g = graph
        self.s = start
        # we never want to visit the same node twice
        # so we need to remember where we have been
        # so we do not go there again
        # this visited list records where we have been
        # To start wth we havent been anywhere, everywhere = False
        # _ = empty variable (anything can go)
        self.visited = [False for _ in range(g.V)]      # for each vertex we have , created a list of falses
        # we want to record how we reached each node
        # which node we came from to reach a given node
        self.parent = [False for _ in range(g.V)]
        # start searching from node s
        self.dfs(start)

    def dfs(self, v):
        # v is our start
        # we are at node v
        # if we are at node v , then we have visited it, change to True
        self.visited[v] = True
        # Where can we go from node v?
        # for each node 'w' that is connected directly to v
        for w in self.g.adj[v]:         # this will return the list of connections in adj
            # have we been here before? (w)
            # if not then go there, if we have, then ignore
            if not self.visited[w]:
                # lets record how we got to w 
                # we got to w from v
                self.parent[w] = v
                # lets go to w and continue from there
                self.dfs(w)
                
    def hasPathto(self, v):
        if v in self.visited:
            return True
        return False
    def pathTo(self, v):
        if v in self.parent:
            return self.parent[v]
        else:
            return None
        
paths = DFSPaths(g, 0)
print(paths.visited)
print(paths.parent)


