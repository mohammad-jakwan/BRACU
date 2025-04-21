def eulerian_path():
    n, m = map(int, input().split())
    if m == 0:
        return r"YES" if n <= 1 else r"NO"

    u = list(map(int, input().split()))
    v = list(map(int, input().split()))

    graph = [[] for _ in range(n + 1)]
    degree = [0] * (n + 1)

    for i in range(m):
        graph[u[i]].append(v[i])
        graph[v[i]].append(u[i])
        degree[u[i]] += 1
        degree[v[i]] += 1

    def dfs(start):
        visited = [False] * (n + 1)
        if not any(degree):  # If no edges.
            return True

        stack = [start]
        visited[start] = True

        while stack:
            node = stack.pop()
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    stack.append(neighbor)

        return all(
            not degree[i] or visited[i] for i in range(1, n + 1)
        )  # ? all function: If the iterable is empty, it returns True.

    start = next(
        (i for i in range(1, n + 1) if degree[i]), 1
    )  # ?  next item from the iterator

    if not dfs(start):
        return r"NO"
    odd_vertices = sum(1 for d in degree[1:] if d % 2)

    return r"YES" if odd_vertices in (0, 2) else r"NO"


print(eulerian_path())
