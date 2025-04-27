import sys

sys.setrecursionlimit(10**6)

N, M = map(int, input().split())

adj = {i: [] for i in range(1, N + 1)}

for _ in range(M):
    line = input().strip()
    if line == "":
        continue
    u, v = line.split()
    u, v = int(u), int(v)
    adj[u].append(v)

visited = {i: r"White" for i in range(1, N + 1)}
cycle = False


def DFS(u):
    global cycle
    if cycle:
        return
    visited[u] = r"Gray"
    for v in adj[u]:
        if visited[v] == r"White":
            DFS(v)
        elif visited[v] == r"Gray":
            cycle = True
            return
    visited[u] = r"Black"


for node in range(1, N + 1):
    if visited[node] == r"White":
        DFS(node)
    if cycle:
        break

if cycle == True:
    print("YES")
else:
    print("NO")
