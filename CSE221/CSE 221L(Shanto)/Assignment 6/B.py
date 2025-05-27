import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())  # * Number of players (N) & number of tackles (M).
edges = [[] for _ in range(n + 1)]

#! If u tackles v then they must be of different types (Robot/Human).
for _ in range(m):
    u, v = map(int, input().split())
    edges[u].append(v)
    edges[v].append(u)

# ? -1: unvisited.
# ?  0: marked as type 1 (could be Robot or Human).
# ?  1: marked as type 2 (diff of type 1).
visited = [-1] * (n + 1)
answer = 0

for i in range(1, n + 1):
    if visited[i] == -1:  # * Found a new unvisited component.
        queue = deque([i])
        visited[i] = 0  #! Marking first player as type 1.
        count = [1, 0]
        bipartite_flag = True

        # TODO: BFS algo. to color players & check if it's component is bipartite.
        while queue:
            u = queue.popleft()
            for v in edges[u]:
                if (
                    visited[v] == -1
                ):  # If player v is unvisited marking v with opposite type of u.
                    visited[v] = 1 - visited[u]
                    count[visited[v]] += 1
                    queue.append(v)
                # ? If v is already visited and same type as u then component is not bipartite.
                elif visited[v] == visited[u]:
                    bipartite_flag = False

        if bipartite_flag:
            answer += max(count)
        else:
            answer += (count[0] + count[1] + 1) // 2

print(answer)
