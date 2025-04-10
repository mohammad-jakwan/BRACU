from collections import defaultdict, deque


def solve():
    n, m = map(int, input().split())

    # Creating adjacency list & counting in-degree.
    graph = defaultdict(list)
    in_degree = [0] * (n + 1)

    # Building the graph.
    for item in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    # ! Queue with nodes having 0 in-degree:
    queue = deque()
    for i in range(1, n + 1):
        if in_degree[i] == 0:
            queue.append(i)

    # TODO: Performing the topological sort.
    result = []
    while queue:
        curr = queue.popleft()
        result.append(curr)

        for neighbor in graph[curr]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)

    # * If valid ordering exists then we print it, else we don't.
    if len(result) != n:
        print(-1)
    else:
        print(*result)


solve()

# 8 8
# 6 4
# 6 2
# 4 2
# 2 1
# 1 7
# 7 5
# 5 8
# 8 3

# 6 4 2 1 7 5 8 3
