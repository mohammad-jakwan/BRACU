from collections import defaultdict, deque

# BFS(G,s): #? (G) Graph starting from vertex s.

# for each vertex u in G.V:
#     u.colour = 0

# Q = Ø ;
# s.colour = 1 #* Discovered but not fully explored.
# ENQUEUE(Q,s)

# while Q ≠ Ø;
#     u = DEQUEUE(Q)
#     for each v in G.Adj[u]:
#         if v.colour == 0:
#             v.colour = 1
#             ENQUEUE(Q,v)


def bfs(graph, start, n):
    visited = [False] * (n + 1)
    queue = deque([start])
    visited[start] = True
    result = []

    while queue:
        vertex = queue.popleft()  # ? Next node for processing.
        result.append(vertex)

        # * Handling all adjacent vertices.
        for neighbor in sorted(
            graph[vertex]
        ):  # TODO: Sorting to get lexicographically smallest order.
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)

    return result


# Input Reading: N (nodes) and M (edges)
N, M = map(int, input().split())

# Adjacency list creation
graph = defaultdict(
    list
)  #!  A dictionary subclass that automatically handles missing keys.
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)  # Since the graph is undirected

# BFS at node 1.
output = bfs(graph, 1, N)

print(*output)
