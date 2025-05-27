import sys
from collections import deque

n = int(input())
x1, y1, x2, y2 = map(int, input().split())

# Using separate dx, dy lists for knight moves. zip takes O(n) time.
dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]

visited = [[-1] * (n + 1) for _ in range(n + 1)]
queue = deque()
queue.append((x1, y1))
visited[x1][y1] = 0

while queue:
    x, y = queue.popleft()
    if x == x2 and y == y2:  # when our target is found.
        break

    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 1 <= nx <= n and 1 <= ny <= n and visited[nx][ny] == -1:
            visited[nx][ny] = visited[x][y] + 1
            queue.append((nx, ny))

print(visited[x2][y2])
