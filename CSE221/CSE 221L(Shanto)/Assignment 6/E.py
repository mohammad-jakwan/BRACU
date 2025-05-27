import sys
import threading
from collections import deque


def solve():
    sys.setrecursionlimit(1 << 25)
    N = int(sys.stdin.readline())
    adj = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        u, v = map(int, sys.stdin.readline().split())
        adj[u].append(v)
        adj[v].append(u)

    def bfs(start):
        visited = [False] * (N + 1)
        dist = [0] * (N + 1)
        q = deque([start])
        visited[start] = True
        farthest = start
        while q:
            node = q.popleft()
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    dist[neighbor] = dist[node] + 1
                    q.append(neighbor)
                    if dist[neighbor] > dist[farthest]:
                        farthest = neighbor
        return farthest, dist[farthest], dist

    #! First BFS to find one end of the diameter
    x, a, b = bfs(1)
    #! Second BFS from x to find the other end and the diameter length.
    y, diameter, elem = bfs(x)

    print(diameter)
    print(x, y)


solve()
