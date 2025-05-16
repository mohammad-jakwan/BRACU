import heapq
import sys
from collections import defaultdict

input = sys.stdin.read


def shortest_path():
    data = input().split()
    idx = 0

    N = int(data[idx])
    M = int(data[idx + 1])
    idx += 2

    u = list(map(int, data[idx : idx + M]))
    idx += M
    v = list(map(int, data[idx : idx + M]))
    idx += M
    w = list(map(int, data[idx : idx + M]))

    graph = defaultdict(list)
    for i in range(M):
        graph[u[i]].append((v[i], w[i]))

    INF = float("inf")
    dist = [[INF] * 2 for _ in range(N + 1)]
    pq = []

    dist[1][0] = 0
    dist[1][1] = 0
    heapq.heappush(pq, (0, 1, -1))

    while pq:
        cost, u, last_parity = heapq.heappop(pq)

        for v_node, weight in graph[u]:
            parity = weight % 2
            if parity == last_parity:
                continue
            if cost + weight < dist[v_node][parity]:
                dist[v_node][parity] = cost + weight
                heapq.heappush(pq, (cost + weight, v_node, parity))

    res = min(dist[N][0], dist[N][1])
    print(res if res != INF else -1)


shortest_path()
