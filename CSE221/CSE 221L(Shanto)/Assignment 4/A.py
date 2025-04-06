def solve():
    # Input Reading: N (nodes) and M (edges)
    N, M = map(int, input().split())

    # Initializing NxN matrix with zeros.
    adj_matrix = [[0] * N for _ in range(N)]

    # M edges will fill data in the matrix.
    for _ in range(M):
        i, j, w = map(int, input().split())
        # Convert to 0-based indexing and fill weight
        adj_matrix[i - 1][j - 1] = w

    for row in adj_matrix:
        print(*row)


# Input:
# 4 3        # 4 nodes, 3 edges
# 1 3 8      # Edge from node 1 to node 3 with weight 8
# 2 4 2      # Edge from node 2 to node 4 with weight 2
# 3 2 5      # Edge from node 3 to node 2 with weight 5


solve()
