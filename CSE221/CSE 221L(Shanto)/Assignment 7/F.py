import heapq
from collections import defaultdict


def second_shortest_path(N, edges, S, D):
    # Creating adjacency list.
    graph = defaultdict(list)
    for starting_node, ending_node, weight in edges:
        graph[starting_node].append((ending_node, weight))
        graph[ending_node].append(
            (starting_node, weight)
        )  # ? You are given a bidirectional weighted graph.

    #! Priority queue to store : Distance, Node and path_count.
    priority_queue = [(0, S, 1)]  # Starting with the source node.
    distances = defaultdict(
        list
    )  # ? Dictionary list stores the shortest and second shortest distances for every node.

    while priority_queue:
        dist, node, path_num = heapq.heappop(priority_queue)

        # TODO: When we already got two paths for current node and the current distance & that's greater than both then we skip it.

        if (
            node in distances
            and len(distances[node]) >= 2
            and dist > distances[node][1][0]
        ):
            continue

        if (
            node not in distances or len(distances[node]) < 2
        ):  #! For a new shortest or second shortest path to current node.
            if node not in distances:
                distances[node] = []
            distances[node].append(
                (dist, path_num)
            )  # ? appending the current distance and path number to the list.
            distances[node].sort()  # * Low distances sorted at first.
            if len(distances[node]) > 2:  # * we only keep up to 2 shortest paths.
                distances[node] = distances[node][:2]

            for next_node, weight in graph[node]:
                heapq.heappush(
                    priority_queue, (dist + weight, next_node, path_num)
                )  # ? heappush adding new distance to the queue.

    # TODO: If we found two paths to the destination then we check for second path always has greater distance.
    if D in distances and len(distances[D]) == 2:
        shortest, second_shortest = distances[D]

        if shortest[0] < second_shortest[0]:
            return second_shortest[0]

    return -1


# -------------------------------------------------------------------------
# Driver code:
# * N = Number of nodes.
# * M = Number of edges.
# * S = Source node.
# * D = Destination node.
N, M, S, D = map(int, input().split())
edges = []
for _ in range(M):
    starting_node, ending_node, weight = map(int, input().split())
    edges.append((starting_node, ending_node, weight))

result = second_shortest_path(N, edges, S, D)
print(result)
# -------------------------------------------------------------------------
