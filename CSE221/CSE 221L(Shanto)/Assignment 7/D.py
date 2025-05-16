import sys
from collections import defaultdict
from heapq import heappop, heappush


def minimum_path_cost(N, M, S, D, weights, edges):
    # Creating adjacency list.
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
    distances = [float("inf")] * (
        N + 1
    )  # * Distances in infinity at first (Not ventured).
    distances[S] = weights[S - 1]  # * Distance to source self weight.

    priority_queue = [
        (weights[S - 1], S)
    ]  # ? Priority queue to store: Distance and Node.

    while priority_queue:
        dist, current = heappop(
            priority_queue
        )  # ? heappop returns the smallest element in the queue.
        if current == D:
            return dist
        if dist > distances[current]:  # Longer path we skip.
            continue

        #! Now checking all paths from current node.
        for next_node in graph[current]:
            new_dist = (
                dist + weights[next_node - 1]
            )  # ! New distance is = current distance + weight of next node

            if new_dist < distances[next_node]:
                distances[next_node] = new_dist
                heappush(
                    priority_queue, (new_dist, next_node)
                )  # ? heappush adds the new distance to the queue.

    return -1  # No path exists from S to D.


# -------------------------------------------------------------------------
# Driver code:
N, M, S, D = map(int, input().split())
weights = list(map(int, input().split()))
edges = []
for _ in range(M):
    u, v = map(int, input().split())
    edges.append((u, v))
# * N = Number of nodes.
# * M = Number of edges.
# * S = Source node.
# * D = Destination node.
result = minimum_path_cost(N, M, S, D, weights, edges)
print(result)
# -------------------------------------------------------------------------
