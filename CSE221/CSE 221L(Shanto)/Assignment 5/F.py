import heapq
from collections import defaultdict


def ancient_order():
    n = int(input())
    words = [input().strip() for _ in range(n)]

    # Create graph and track indegree
    graph = defaultdict(set)
    indegree = defaultdict(int)
    chars = set()

    # Build graph from adjacent words
    for i in range(n - 1):
        w1, w2 = words[i], words[i + 1]
        min_len = min(len(w1), len(w2))

        # Add all characters to set
        chars.update(w1)
        chars.update(w2)

        # Find first differing character and check prefix condition
        found = False
        for j in range(min_len):
            if w1[j] != w2[j]:
                # Check for cyclic dependency
                if (
                    w1[j] in graph
                    and w2[j] in graph[w1[j]]
                    or w2[j] in graph
                    and w1[j] in graph[w2[j]]
                ):
                    print(-1)
                    return

                if w2[j] not in graph[w1[j]]:
                    graph[w1[j]].add(w2[j])
                    indegree[w2[j]] += 1
                found = True
                break

        # If no different character found and first word is longer, it's invalid
        if not found and len(w1) > len(w2):
            print(-1)
            return

    # Priority queue for lexicographically smallest order
    pq = []
    # Ensure we process characters in lexicographical order for zero indegree
    for c in sorted(chars):
        if indegree[c] == 0:
            heapq.heappush(pq, c)

    result = []
    visited = set()

    while pq:
        curr = heapq.heappop(pq)
        if curr in visited:
            print(-1)
            return
        visited.add(curr)
        result.append(curr)

        # Process neighbors in sorted order for lexicographically smallest result
        for neighbor in sorted(graph[curr]):
            indegree[neighbor] -= 1
            if indegree[neighbor] == 0:
                heapq.heappush(pq, neighbor)

    # Check if we visited all characters
    if len(result) != len(chars):
        print(-1)
        return

    print("".join(result))


if __name__ == "__main__":
    ancient_order()
