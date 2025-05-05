import sys
from heapq import heappop, heappush


# TODO: Dijkstra's algorithm to find the shortest path from source to destination.
def solve(n, edges, weights, src, destination):
    adjacent = [[] for _ in range(n + 1)]  # Creating adjacency list with weights.
    for i in range(len(edges)):
        u, v, w = edges[i], weights[0][i], weights[1][i]
        adjacent[u].append((v, w))

    distance = [INF] * (n + 1)
    parent = [-1] * (n + 1)
    distance[src] = 0
    priority_queue = [(0, src)]  # ? Priority queue to store (distance & node).

    while priority_queue:
        d, u = heappop(priority_queue)
        if u == destination:  # * If we reached our destination no need to venture.
            break
        if d > distance[u]:  # *If we've found a longer path we skip.
            continue

        # Checking all neighbors for current node.
        for v, w in adjacent[u]:
            if distance[u] + w < distance[v]:
                distance[v] = distance[u] + w
                parent[v] = u
                heappush(priority_queue, (distance[v], v))

    if distance[destination] == INF:  #! when destination is unreachable
        return -1, []

    # ? Path construction.
    path = []
    curr = destination
    while curr != -1:
        path.append(curr)
        curr = parent[curr]

    return (
        distance[destination],
        path[::-1],
    )  # ! Reverse path to verify from source to destination.


# --------------------------------------------------------------------------------
# Driver code:
input = sys.stdin.readline
INF = float("inf")

n, m, s, d = map(int, input().split())
u = list(map(int, input().split()))  # * Source nodes.
v = list(map(int, input().split()))  # * Destination nodes.
w = list(map(int, input().split()))  # * Weights.
distance, path = solve(n, u, [v, w], s, d)  # Function call.

# Output:
if distance == -1:
    print(-1)
else:
    print(distance)
    print(*path)
# --------------------------------------------------------------------------------
