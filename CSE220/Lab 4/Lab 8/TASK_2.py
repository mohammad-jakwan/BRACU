class WeightedGraph:
    def __init__(self, num_vertices, max_edges):

        self.num_vertices = num_vertices
        self.max_edges = max_edges

        self.matrix = [
            [0] * num_vertices for i in range(num_vertices)
        ]  #! Adjacency matrix filled with infinity values.

        # ? For each vertex, two arrays: one for neighbors and other one for weights.
        self.neighbors = [
            [-1] * max_edges for _ in range(num_vertices)
        ]  # * [-1] to indicate empty slots
        self.weights = [[-1] * max_edges for i in range(num_vertices)]

        # ? Keeping the track of How many edges each vertex currently has
        self.edge_counts = [0] * num_vertices

        # TODO: Adds a weighted edge between vertex1 and vertex2.
        # * Since this is an undirected graph, we add the connection both ways.
        # ? vertex1: First vertex of the edge.
        # ? vertex2: Second vertex of the edge.
        # ? weight: The weight of the edge.

    def add_edge(self, vertex1, vertex2, weight):
        self.matrix[vertex1][vertex2] = weight
        self.matrix[vertex2][vertex1] = weight

        # Then add to our array-based adjacency list for vertex1
        index1 = self.edge_counts[vertex1]
        if index1 < self.max_edges:
            self.neighbors[vertex1][index1] = vertex2
            self.weights[vertex1][index1] = weight
            self.edge_counts[vertex1] += 1

        # for vertex2....
        index2 = self.edge_counts[vertex2]
        if index2 < self.max_edges:
            self.neighbors[vertex2][index2] = vertex1
            self.weights[vertex2][index2] = weight
            self.edge_counts[vertex2] += 1

    def max_weighted_sum_using_matrix(self):

        max_sum = 0
        max_vertex = 0

        # For each vertex
        for vertex in range(self.num_vertices):
            current_sum = 0

            # Adding up all edge weights
            for weight in self.matrix[vertex]:
                if weight != 0:
                    current_sum += weight

            # Update maximum if necessary
            if current_sum > max_sum:
                max_sum = current_sum
                max_vertex = vertex

        return max_vertex, max_sum

    # TODO: Finding the vertex with maximum sum of edge weights using arrays.

    def max_weighted_sum_using_arrays(self):
        max_sum = 0
        max_vertex = 0

        # For each vertex:
        for vertex in range(self.num_vertices):
            current_sum = 0

            #! Adding weights for all of its edges.
            for i in range(self.edge_counts[vertex]):
                if self.weights[vertex][i] != -1:
                    current_sum += self.weights[vertex][i]

            if current_sum > max_sum:
                max_sum = current_sum
                max_vertex = vertex

        # * Returns the vertex number & its weighted sum.
        return max_vertex, max_sum


# Driver Code
graph = WeightedGraph(7, 6)  #! As we got the degree from task 1.

# Vertex, Neighbour-Vertex, Weight
edges = [
    (0, 1, 5),
    (0, 2, 4),
    (0, 3, 3),
    (0, 5, 6),  #!!! edges from vertex 0
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
# Add each edge to our graph
for v1, v2, w in edges:
    graph.add_edge(v1, v2, w)

# Finding vertex with maximum weighted sum:
matrix_result = graph.max_weighted_sum_using_matrix()
array_result = graph.max_weighted_sum_using_arrays()
print("Using adjacency matrix:")
print(
    f"Vertex -> [{matrix_result[0]}] has the highest weight; And sum of that vertex is {matrix_result[1]}."
)
print("\nUsing arrays:")
print(
    f"Vertex -> [{array_result[0]}] has the highest weight; And sum of that vertex is {array_result[1]}."
)
