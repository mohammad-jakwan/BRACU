class DirectedGraph:
    def __init__(self, num_vertices, max_edges):
        self.num_vertices = num_vertices
        self.max_edges = (
            max_edges  #! Any vertex can have Maximum number of outgoing edges.
        )

        self.matrix = [[0] * num_vertices for i in range(num_vertices)]

        # ? For each vertex, storing outgoing edges in array.
        self.out_neighbors = [
            [-1] * max_edges for _ in range(num_vertices)
        ]  # * [-1] to indicate empty slots
        self.weights = [[-1] * max_edges for _ in range(num_vertices)]

        # Track number of outgoing edges for each vertex
        self.out_edge_counts = [0] * num_vertices

    def add_edge(self, from_vertex, to_vertex, weight=1):
        """
        Adds a directed edge from from_vertex to to_vertex.
        For unweighted graphs, weight defaults to 1.
        """
        # Add to matrix
        self.matrix[from_vertex][to_vertex] = weight

        # Add to outgoing edges array
        if self.out_edge_counts[from_vertex] < self.max_edges:
            idx = self.out_edge_counts[from_vertex]
            self.out_neighbors[from_vertex][idx] = to_vertex
            self.weights[from_vertex][idx] = weight
            self.out_edge_counts[from_vertex] += 1

    # TODO: Task 1: Find vertex with maximum out-degree
    def find_max_out_degree_matrix(self):

        max_degree = 0
        max_vertex = 0

        for vertex in range(self.num_vertices):
            # Counting values in row for (outgoing edges).
            degree = 0
            for j in range(self.num_vertices):
                if self.matrix[vertex][j] != 0:
                    degree += 1

            if degree > max_degree:
                max_degree = degree
                max_vertex = vertex

        return max_vertex, max_degree

    def find_max_out_degree_arrays(self):

        max_degree = 0
        max_vertex = 0

        for vertex in range(self.num_vertices):
            degree = self.out_edge_counts[vertex]
            if degree > max_degree:
                max_degree = degree
                max_vertex = vertex

        #! Returning vertex number and its out-degree.
        return max_vertex, max_degree

    # TODO: Task 2: Find vertex with maximum outgoing weight sum.
    def max_weight_sum_matrix(self):

        max_sum = 0
        max_vertex = 0

        for vertex in range(self.num_vertices):
            current_sum = 0
            for j in range(self.num_vertices):
                if self.matrix[vertex][j] != 0:
                    current_sum += self.matrix[vertex][j]

            if current_sum > max_sum:
                max_sum = current_sum
                max_vertex = vertex

        return max_vertex, max_sum

    def max_weighted_sum_of_arrays(self):
        max_sum = 0
        max_vertex = 0

        for vertex in range(self.num_vertices):
            current_sum = 0
            for i in range(self.out_edge_counts[vertex]):
                current_sum += self.weights[vertex][i]

            if current_sum > max_sum:
                max_sum = current_sum
                max_vertex = vertex

        return max_vertex, max_sum


# Drive codes
graph = DirectedGraph(7, 6)
# * Directed edges (From, To, Weights)
edges = [
    (0, 1, 5),
    (0, 2, 4),
    (0, 3, 3),
    (0, 5, 6),  # edges from vertex 0
    (1, 2, 2),
    (1, 3, 6),
    (1, 4, 3),
    (1, 5, 3),  # edges from vertex 1
    (2, 3, 4),
    (2, 4, 5),
    (2, 5, 4),
    (2, 6, 3),  # edges from vertex 2
    (3, 5, 5),
    (3, 6, 4),  # edges from vertex 3
    (4, 5, 2),  # edges from vertex 4
    (5, 6, 3),  # edges from vertex 5
]
for from_v, to_a_v, weight in edges:
    graph.add_edge(from_v, to_a_v, weight)


# --------------------------------------------------------------------------------------#

# Task 1: Find maximum out-degree
matrix_degree = graph.find_max_out_degree_matrix()
array_degree = graph.find_max_out_degree_arrays()
print("\nTask 1 - Maximum Out-degree:")
print(f"Matrix: Vertex {matrix_degree[0]} has max out-degree of {matrix_degree[1]}.")
print(f"Arrays: Vertex {array_degree[0]} has max out-degree of {array_degree[1]}.")

# --------------------------------------------------------------------------------------#

# Task 2: Find maximum outgoing weight sum
matrix_weight = graph.max_weight_sum_matrix()
array_weight = graph.max_weighted_sum_of_arrays()
print("\nTask 2 - Maximum Outgoing Weight Sum:")
print(f"Matrix: Vertex {matrix_weight[0]} has max weight sum of {matrix_weight[1]}.")
print(f"Arrays: Vertex {array_weight[0]} has max weight sum of {array_weight[1]}.")
