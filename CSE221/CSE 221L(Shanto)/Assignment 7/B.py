import sys
from heapq import heappop, heappush


def dijkstra_algo(n, adjacent, start):
    distant = [INF] * (n + 1)
    distant[start] = 0
    priority_queue = [(0, start)]

    while priority_queue:
        d, u = heappop(priority_queue)  # ? heappop returns the smallest element.

        if d > distant[u]:
            continue

        for v, w in adjacent[u]:
            if distant[u] + w < distant[v]:
                distant[v] = distant[u] + w
                heappush(
                    priority_queue, (distant[v], v)
                )  # ? heappush adds an element to the heap.

    return distant


input = sys.stdin.readline
INF = float("inf")

n, m, s, t = map(int, input().split())

# Creating adjacency lists.
adjacent = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    adjacent[u].append((v, w))

# * Shortest paths from both starting points.
alice_distance = dijkstra_algo(n, adjacent, s)  # Alice's distance.
Bob_distance = dijkstra_algo(n, adjacent, t)  # Bob's distance.

#! Finding meeting point with minimum and maximum distance.
min_and_max_distance = INF
meeting_point = -1

for i in range(1, n + 1):
    if (
        alice_distance[i] != INF and Bob_distance[i] != INF
    ):  # * Both must be able to reach the same point for meeting.
        max_dist = max(
            alice_distance[i], Bob_distance[i]
        )  # * Maximum of times as that's when both could be there.
        if max_dist < min_and_max_distance:  # * When there's a better path.
            min_and_max_distance = max_dist
            meeting_point = i
        elif (
            max_dist == min_and_max_distance and i < meeting_point
        ):  # * If times are equal we take smaller weighted node.
            meeting_point = i

if meeting_point == -1:
    print(-1)
else:
    print(min_and_max_distance, meeting_point)
