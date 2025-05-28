import sys
from array import array
from collections import deque

input = sys.stdin.read
data = list(map(int, input().split()))
index = 0
n = data[index]  # * Number of nodes.
index += 1
r = data[index]  # * Root of the tree.
index += 1

edges = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u = data[index]
    v = data[index + 1]
    edges[u].append(v)
    edges[v].append(u)
    index += 2

# ? DFS for calculating the subtree sizes.
subtree = array("I", [0] * (n + 1))  # !'I' = unsigned int.
visited = array("b", [0] * (n + 1))

_stacks = [r]
order = []
while _stacks:
    node = _stacks.pop()
    visited[node] = 1
    order.append(node)
    for v in edges[node]:
        if not visited[v]:
            _stacks.append(v)

#! Post-order processing to calculate subtree sizes.
for node in reversed(order):
    subtree[node] = 1
    for v in edges[node]:
        if subtree[v] > 0:
            subtree[node] += subtree[v]

query = data[index]  # * query count.
index += 1
output = []
for _ in range(query):
    x = data[index]
    output.append(str(subtree[x]))
    index += 1

print("\n".join(output))
