import sys
from collections import defaultdict

#! Recursion limit to handle large graphs (N ≤ 2×10^5).
sys.setrecursionlimit(200005)


def dfs(graph, current, visited):
    # TODO: Current node marked when visited & adding it to result.
    visited[current] = True
    print(current, end=" ")

    # Traversing all adjacent nodes.
    for neighbor in sorted(graph[current]):  # Sorting for consistent output.
        if not visited[neighbor]:
            dfs(graph, neighbor, visited)


def solve():
    # Input Reading: N (nodes) and M (edges)
    N, M = map(int, input().split())
    u = list(map(int, input().split()))
    v = list(map(int, input().split()))

    # Adjacency list creation.
    graph = defaultdict(list)
    for i in range(M):
        graph[u[i]].append(v[i])
        graph[v[i]].append(u[i])  # * Undirected graph

    # ? visited array
    visited = [False] * (N + 1)
    dfs(graph, 1, visited)


solve()
