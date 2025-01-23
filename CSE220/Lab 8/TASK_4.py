class DirectedGraph:
    def __init__(self, num_vertices):
        self.num_vertices = num_vertices

        self.matrix = [[0] * num_vertices for num in range(num_vertices)]

        # TODO: Adjacency list: Preallocate fixed-size lists. 😭
        self.adj_list = [[] for Lists in range(num_vertices)]
        for i in range(num_vertices):
            self.adj_list[i] = [
                None
            ] * num_vertices  #!!! Max size of neighbors preallocated 😭
            self.adj_list[i][0] = 0  # * First element holds the count of neighbors.

    def add_edge(self, from_vertex, to_vertex, weight):

        # Update adjacency matrix
        self.matrix[from_vertex][to_vertex] = weight

        # * manually adding to adjacency list.
        count = self.adj_list[from_vertex][0]  # Get current count of neighbors
        self.adj_list[from_vertex][count + 1] = (to_vertex, weight)  # Add neighbor
        self.adj_list[from_vertex][0] += 1  # Update count


class UndirectedGraph:
    def __init__(self, num_vertices):
        self.num_vertices = num_vertices

        self.matrix = [[0] * num_vertices for num in range(num_vertices)]

        # TODO: Adjacency list: Preallocate fixed-size lists.😭
        self.adj_list = [[] for lists in range(num_vertices)]
        for i in range(num_vertices):
            self.adj_list[i] = [
                None
            ] * num_vertices  #!!! Max size of neighbors preallocated 😭
            self.adj_list[i][0] = 0  # * First element holds the count of neighbors.

    def convert_from_directed(self, directed_graph):
        # TODO: TASK 2
        #! Converting into adjacency matrix
        for i in range(directed_graph.num_vertices):
            for j in range(directed_graph.num_vertices):
                if directed_graph.matrix[i][j] != float("inf"):
                    self.matrix[i][j] = directed_graph.matrix[i][j]
                    self.matrix[j][i] = directed_graph.matrix[i][j]  #! Reverse edge
        # TODO: TASK 1
        #! Converting into adjacency list
        for u in range(directed_graph.num_vertices):
            neighbor_count = directed_graph.adj_list[u][0]
            for k in range(1, neighbor_count + 1):
                v, weight = directed_graph.adj_list[u][k]
                self.add_edge_to_list(u, v, weight)
                self.add_edge_to_list(v, u, weight)

    def add_edge_to_list(self, vertex, neighbor, weight):
        count = self.adj_list[vertex][0]  # * Get current count of neighbors
        self.adj_list[vertex][count + 1] = (neighbor, weight)  # * Adding neighbors.
        self.adj_list[vertex][0] += 1  # * Updating count.


num_vertices = 7
directed_graph = DirectedGraph(num_vertices)

# * Directed edges (From, To, Weights)
directed_edges = [
    (0, 1, 5),
    (0, 2, 3),
    (0, 3, 6),
    (1, 4, 4),
    (1, 5, 2),
    (2, 5, 8),
    (2, 6, 7),
    (3, 4, 3),  #
    (3, 6, 2),
    (4, 5, 6),
    (4, 6, 5), #
    (5, 6, 4),
    (5, 3, 1),
    (6, 0, 7),
    (1, 3, 3),
    (2, 4, 2),
]

for from_vertex, to_vertex, weight in directed_edges:
    directed_graph.add_edge(from_vertex, to_vertex, weight)


undirected_graph = UndirectedGraph(num_vertices)
undirected_graph.convert_from_directed(directed_graph)

print("Adjacency Matrix of Undirected Graph:")
for row in undirected_graph.matrix:
    print(row)
print("\nAdjacency List of Undirected Graph:")
for vertex in range(num_vertices):
    neighbors = []
    neighbor_count = undirected_graph.adj_list[vertex][0]
    for k in range(1, neighbor_count + 1):
        neighbors.append(undirected_graph.adj_list[vertex][k])
    print(f"Vertex {vertex}: {neighbors}")




# (ㅠ﹏ㅠ) Don't reduce too much marks.
