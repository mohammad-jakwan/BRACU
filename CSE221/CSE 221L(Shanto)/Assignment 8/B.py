def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])  # Path compression from A.
    return parent[x]


def union(parent, rank, x, y):
    parent_xxx, parent_yy = find(parent, x), find(parent, y)  # * Root of x and y.
    if parent_xxx == parent_yy:
        return
    if rank[parent_xxx] < rank[parent_yy]:
        parent_xxx, parent_yy = parent_yy, parent_xxx
    parent[parent_yy] = parent_xxx
    if rank[parent_xxx] == rank[parent_yy]:
        rank[parent_xxx] += 1  #! Increasing the rank for the new root.


def krukshetrokal(N, edges):
    # TODO: Disjoint data set structure creation.
    # Then Sort edges by their weight.
    parent = list(range(N + 1))
    rank = [0] * (N + 1)
    edges.sort(key=lambda x: x[2])  # loop exceeds time limit.

    total_cost = 0
    edges_used = 0

    # TODO: the minimum total maintenance cost;
    # ! Ascending order of weight processing for the edges.
    for starting_node, ending_node, weight in edges:
        if find(parent, starting_node) != find(
            parent, ending_node
        ):  # * Not in the same set.
            union(parent, rank, starting_node, ending_node)
            total_cost += weight
            edges_used += 1
            if edges_used == N - 1:  # ! MST Algo.
                break

    return total_cost


# ------------------------------------------------------------------------
# Driver code:
# * N = Number of nodes.
# * M = Number of edges.
N, m = map(int, input().split())
edges = []
for _ in range(m):
    starting_node, ending_node, weight = map(int, input().split())
    edges.append((starting_node, ending_node, weight))


# 5 7
# 1 2 8
# 1 4 3
# 1 5 4                 16
# 2 4 8
# 2 3 5
# 4 3 4
# 3 5 5


print(krukshetrokal(N, edges))
# ------------------------------------------------------------------------
# * Time complexity: O(M log M + M * α(N))
