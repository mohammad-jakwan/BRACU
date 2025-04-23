import heapq
from collections import defaultdict, deque


def shortest_path(N, edges, source, dest):
    # * Creating adjacency list.
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    # * Then sorting adjacency lists for lexicographical order.
    for node in graph:
        graph[node].sort()

    # BFS while visiting parent.
    parent = [-1] * (N + 1)
    distance = [-1] * (N + 1)
    q = deque([(source, 0)])
    distance[source] = 0

    while q:
        node, dist = q.popleft()  # form left side of queue.
        # * Marking the node as visited.
        if node == dest:
            break

        for neighbor in graph[node]:
            if distance[neighbor] == -1:
                distance[neighbor] = dist + 1
                parent[neighbor] = node
                q.append((neighbor, dist + 1))

    # when destination ain't reachable.
    if distance[dest] == -1:
        return -1, []

    # TODO: path optimization:
    # ! Reconstructing the path from destination to source.
    path = []
    curr = dest
    while curr != -1:
        path.append(curr)
        curr = parent[curr]
    path.reverse()

    return distance[dest], path


# ? Input Reading: N (nodes), M (edges) S (source) and D (destination).
N, M, S, D = map(int, input().split())
u = list(map(int, input().split()))
v = list(map(int, input().split()))

# Edges list
edges = list(zip(u, v))  #! zip(u, v) creates pairs of edges.

# Finally, Finding the shortest path.
dist, path = shortest_path(N, edges, S, D)
print(dist)
if dist != -1:
    print(*path)
