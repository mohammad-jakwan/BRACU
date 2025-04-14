def solve():
    N = int(input())  # Number of nodes.

    # * NxN matrix with zeros.
    adj_matrix = [[0] * N for _ in range(N)]

    for i in range(N):
        # Read each line of adjacency list
        adj_list = list(map(int, input().split()))
        k = adj_list[0]  # ? Number of adjacent nodes.

        # Filling the matrix for each adjacent node.
        for j in range(1, k + 1):
            destination = adj_list[j]
            adj_matrix[i][destination] = 1

    for row in adj_matrix:
        print(*row)  #! * operator is the unpacking operator


solve()
