from collections import deque


def bfs(graph, start, end):
    visited = set()
    queue = deque([(start, [start])])  # Storing (node, path) pairs
    visited.add(start)

    while queue:
        node, path = queue.popleft()
        if node == end:
            return len(path) - 1, path  #! path is number of edges, hence length - 1.

        for next_node in graph[node]:
            if next_node not in visited:
                visited.add(next_node)
                new_path = path + [next_node]
                queue.append((next_node, new_path))

    return None, []  # * No path found


# Read input
# ? n = number of nodes,
# ? m = number of edges,
# ? s = start node,
# ? d = destination node,
# ? k = intermediate node
n, m, s, d, k = map(int, input().split())

# Adjacency list creation.
graph = {}
for i in range(1, n + 1):
    graph[i] = []

# Reading the edges.
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)

# * Finding path from S to K.
dist1, path1 = bfs(graph, s, k)
if dist1 is None:
    print(-1)
    exit()

# * Finding path from K to D.
dist2, path2 = bfs(graph, k, d)
if dist2 is None:
    print(-1)
    exit()

#! Combining paths (removed K from second path so that we can avoid duplication).
total_path = path1 + path2[1:]
print(dist1 + dist2)
print(*total_path)
