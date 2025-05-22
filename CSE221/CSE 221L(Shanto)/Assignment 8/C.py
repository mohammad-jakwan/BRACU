from collections import defaultdict, deque


class DSU:  # Disjoint Set Union.
    def __init__(self, N):
        self.parent = list(
            range(N + 1)
        )  # ! Each person has their own set with size 1 and +1 because people are numbered from 1.
        self.rank = [0] * (N + 1)  # * array initialization with 1;

    def find(self, x):
        # link: http://www.shafaetsplanet.com/?p=763
        # TODO: Finding the Root/Representative of the set with path compression.
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # * Path compression.
        return self.parent[x]

    def union(self, x, y):
        # Merging two sets and returning the size of the set.
        parent_xxx = self.find(x)
        parent_yy = self.find(y)
        if parent_xxx == parent_yy:
            return False
        # TODO: Union by size:-
        # ! we add smaller tree under root of a larger tree.
        if self.rank[parent_xxx] < self.rank[parent_yy]:
            parent_xxx, parent_yy = parent_yy, parent_xxx
        self.parent[parent_yy] = parent_xxx
        if self.rank[parent_xxx] == self.rank[parent_yy]:
            self.rank[parent_xxx] += 1
        return True


def krukshetrokal(N, edges, exclude_edge=None):
    dsu = DSU(N)
    total_cost = 0
    used_edges = []

    for starting_node, ending_node, weight in edges:
        if exclude_edge is not None:
            ex_u, ex_v, ex_w = exclude_edge
            if (starting_node == ex_u and ending_node == ex_v and weight == ex_w) or (
                starting_node == ex_v and ending_node == ex_u and weight == ex_w
            ):
                continue
        if dsu.union(starting_node, ending_node):
            total_cost += weight
            used_edges.append((starting_node, ending_node, weight))

    if len(used_edges) != N - 1:
        return float("inf"), []
    root = dsu.find(1)
    for i in range(2, N + 1):
        if dsu.find(i) != root:
            return float("inf"), []

    return total_cost, used_edges


def second_best_MST(N, edges):
    sorted_edges = sorted(
        edges, key=lambda x: x[2]
    )  # ? Sorting edges once by weight; Here lambda is used to sort by the third element of the tuple.
    best_cost, best_mst = krukshetrokal(N, sorted_edges)
    if best_cost == float("inf"):
        return -1

    # * MST edge set creation for quick lookup guide from KKP.
    mst_edges_set = set()
    for u, v, w in best_mst:
        mst_edges_set.add((min(u, v), max(u, v), w))

    adj = defaultdict(list)  # Adjacency list for MST.
    for u, v, w in best_mst:
        adj[u].append((v, w))
        adj[v].append((u, w))

    second_best = float("inf")

    # TODO: First approach: Removing each MST edge.
    for mst_edge in best_mst:
        cost, _ = krukshetrokal(N, sorted_edges, mst_edge)
        if cost > best_cost:
            second_best = min(second_best, cost)

    # TODO: Second approach: Try each non-MST edge.
    for u, v, w in sorted_edges:
        if (min(u, v), max(u, v), w) in mst_edges_set:
            continue

        # Finding path between starting_node and ending_node in MST.
        visited = [False] * (N + 1)  # * Visited array for BFS.
        parent = [(-1, -1)] * (N + 1)  # * (parent, edge_weight)
        queue = deque([u])
        visited[u] = True
        found = False

        while queue and not found:
            curr = queue.popleft()
            for nei, wei in adj[curr]:
                if not visited[nei]:
                    visited[nei] = True
                    parent[nei] = (curr, wei)
                    if nei == v:
                        found = True
                        break
                    queue.append(nei)

        #! Reverse path to find the maximum weight edge.
        if found:
            max_weight = float("-inf")
            curr = v
            while parent[curr][0] != -1:
                max_weight = max(max_weight, parent[curr][1])
                curr = parent[curr][0]

            if max_weight != float("-inf"):
                new_cost = (
                    best_cost - max_weight + w
                )  #! Always replacing the max edge in the cycle.
                if new_cost > best_cost:
                    second_best = min(second_best, new_cost)

    return second_best if second_best != float("inf") else -1


# ------------------------------------------------------------------------
# Driver code:
# * N = Number of nodes.
# * m = Number of edges.
N, m = map(int, input().split())
edges = []
for _ in range(m):
    starting_node, ending_node, weight = map(int, input().split())
    edges.append((starting_node, ending_node, weight))
print(second_best_MST(N, edges))
# ------------------------------------------------------------------------
