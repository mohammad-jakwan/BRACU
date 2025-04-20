import heapq

# Number of cities (N) & roads (M).
n, m = map(int, input().split())

# Creating adjacency list for graph representation.
graph = [[] for _ in range(n + 1)]

# * Mapping (weight assignment) road connections and danger levels.
for weight in range(m):
    a, b, danger = map(int, input().split())
    graph[a].append((b, danger))
    graph[b].append((a, danger))

# Initialize danger levels array with infinity
minimum_Danger = [float("inf")] * (n + 1)
minimum_Danger[1] = 0  # Starting city has 0 danger

# todo: Priority queue to hold (current_max_danger, city).
PriorityQueues = [(0, 1)]

while PriorityQueues:
    current_danger, current_city = heapq.heappop(PriorityQueues)

    # * When we found a better path -> we can skip processing.
    if current_danger > minimum_Danger[current_city]:
        continue

    # Neighboring cities:
    for next_city, danger_level in graph[current_city]:
        # ! Danger and the danger level of our chosen new road.
        new_danger = max(
            current_danger, danger_level
        )  #! The maximum danger on this path is the max of current path

        # If we found a path with less maximum danger
        if new_danger < minimum_Danger[next_city]:
            minimum_Danger[next_city] = new_danger
            heapq.heappush(PriorityQueues, (new_danger, next_city))


# 6 5
# 1 2 3
# 1 4 5
# 1 6 2
# 2 6 3
# 4 6 1

# 0 3 -1 2 -1 2


result = []
for i in range(1, n + 1):
    if minimum_Danger[i] == float("inf"):
        result.append(-1)
    else:
        result.append(minimum_Danger[i])

print(*result)
