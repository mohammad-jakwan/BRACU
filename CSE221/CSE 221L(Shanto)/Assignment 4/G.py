def gcd(a, b):
    while b:
        a, b = b, a % b  # ? Euclidean algorithm to find Greatest Common Divisor.
    return a


def creating_graph_path(N):
    # Adjacency list creation for coprime numbers.
    graph = [[] for _ in range(N + 1)]

    # * Now Edges between coprime numbers.
    for i in range(1, N + 1):
        for j in range(i + 1, N + 1):
            if gcd(i, j) == 1:
                graph[i].append(j)
                graph[j].append(i)

    # ! Neighbors for each vertex
    for i in range(1, N + 1):
        graph[i].sort()

    return graph


def kth_neighbor(graph, x, k):
    # ! if k is greater than number of neighbors we return -1. Otherwise, we return the kth smallest neighbor.
    if k > len(graph[x]):
        return -1
    return graph[x][k - 1]  # * smallest neighbor is (k-1 for 0-based indexing).


N, Q = map(int, input().split())
graph = creating_graph_path(N)
for i in range(Q):
    x, k = map(int, input().split())
    print(kth_neighbor(graph, x, k))
