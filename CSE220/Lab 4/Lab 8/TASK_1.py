def find_max_degree_matrix(adj_matrix):
    n = len(adj_matrix)  # Number of vertices
    max_degree = 0
    max_degree_vertex = 0

    # For each vertex
    for i in range(n):
        # todo: Calculating its degree by summing its row in the matrix.
        current_degree = sum(adj_matrix[i])

        # Update maximum if current degree is higher.
        if current_degree > max_degree:
            max_degree = current_degree
            max_degree_vertex = i

    #! returns as tuple: (max_degree, vertex_index)
    return max_degree, max_degree_vertex


def find_max_degree_list(adj_list):

    max_degree = 0
    max_degree_vertex = 0

    # For each vertex
    for vertex in range(len(adj_list)):
        # * Degree by counting neighbors in the adjacency list.
        current_degree = len(adj_list[vertex])

        # ? Update maximum, if current degree is higher.
        if current_degree > max_degree:
            max_degree = current_degree
            max_degree_vertex = vertex

    return max_degree, max_degree_vertex


# Driver Code:
# Adjacency Matrix representation of my graph
adj_matrix = [
    [0, 1, 1, 1, 0, 1, 0],  # Vertex 0
    [1, 0, 1, 1, 1, 1, 0],  # Vertex 1
    [1, 1, 0, 1, 1, 1, 1],  # Vertex 2
    [1, 1, 1, 0, 0, 1, 1],  # Vertex 3
    [0, 1, 1, 0, 0, 1, 0],  # Vertex 4
    [1, 1, 1, 1, 1, 0, 1],  # Vertex 5
    [0, 0, 1, 1, 0, 1, 0],  # Vertex 6
]

# Adjacency List representation of my graph
adj_list = [
    [1, 2, 3, 5],           # Vertex 0
    [0, 2, 3, 4, 5],        # Vertex 1
    [0, 1, 3, 4, 5, 6],     # Vertex 2
    [0, 1, 2, 5, 6],        # Vertex 3
    [1, 2, 5],              # Vertex 4
    [0, 1, 2, 3, 4, 6],     # Vertex 5
    [2, 3, 5],              # Vertex 6
]

# Function calls
matrix_result = find_max_degree_matrix(adj_matrix)
list_result = find_max_degree_list(adj_list)

print(f"Matrix Implemented Max Degree: {matrix_result[0]}, Vertex: {matrix_result[1]}")
print(f"List Implementation - Max Degree: {list_result[0]}, Vertex: {list_result[1]}")
