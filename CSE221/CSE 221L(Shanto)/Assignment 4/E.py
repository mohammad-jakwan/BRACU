def solve():
    # Input Reading: N (nodes) and M (edges)
    N, M = map(int, input().split())

    # Input of the source vertices.
    u = list(map(int, input().split()))

    # Input of the destination vertices.
    v = list(map(int, input().split()))

    # in-degree and out-degree arrays for each vertex;  (1-based indexing).
    in_degree = [0] * (N + 1)
    out_degree = [0] * (N + 1)
    for i in range(M):
        out_degree[u[i]] += 1  # *increment out_degree of source vertex.
        in_degree[v[i]] += 1  # *increment in_degree of destination vertex.

    # ! differences (in_degree - out_degree):
    result = []
    for i in range(1, N + 1):
        result.append(in_degree[i] - out_degree[i])

    print(*result)


# 5 10
# 2 5 4 3 2 4 3 4 1 3
# 5 1 5 5 1 2 2 1 3 4

# 2 0 -2 -2 2

solve()
