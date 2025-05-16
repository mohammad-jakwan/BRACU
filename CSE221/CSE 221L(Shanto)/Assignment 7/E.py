import heapq
from collections import defaultdict

# * dp[node][parity] -> shortest distance to ending node with edge of parity.


def shortest_path(n, m, starting_node, ending_node, weight):
    # Creating adjacency list.
    graph = defaultdict(list)
    for i in range(m):
        graph[starting_node[i]].append((ending_node[i], weight[i], i + 1))

    distance = {}
    for i in range(1, n + 1):
        distance = {
            node: {0: float("inf"), 1: float("inf")} for node in range(1, n + 1)
        }

    priority_queue = [
        (0, 1, -1)
    ]  # ? Priority queue: d_tance, node and last_edge_parity) ; Starting from node 1 with no previous edge.
    distance[1][0] = 0  # * Distance from node 1 and parity 0.
    distance[1][1] = 0  # * Distance from node 1 and parity 1.

    while priority_queue:
        d, starting_node, previous_parity = heapq.heappop(priority_queue)

        # TODO: Checking if minimum of both parities.
        if d > min(
            distance[starting_node][0], distance[starting_node][1]
        ):  # * If we already found a shorter path to this node with the same parity, we skip it.
            continue

        for ending_node, weight, edge_number in graph[starting_node]:
            current_parity = edge_number % 2  # * Edge parity odd (1) or even (0).

            if previous_parity == -1 or current_parity != previous_parity:
                new_distance = d + weight
                if (
                    new_distance < distance[ending_node][current_parity]
                ):  # If we found a shorter path we update and push it to the queue.
                    distance[ending_node][current_parity] = new_distance
                    heapq.heappush(
                        priority_queue, (new_distance, ending_node, current_parity)
                    )

    # * Minimum of both parities for reaching node n.
    result = min(distance[n][0], distance[n][1])
    return result if result != float("inf") else -1


# -------------------------------------------------------------------------
# Driver code:
n, m = map(int, input().split())
starting_node = list(map(int, input().split()))
ending_node = list(map(int, input().split()))
weight = list(map(int, input().split()))
print(shortest_path(n, m, starting_node, ending_node, weight))
# -------------------------------------------------------------------------
