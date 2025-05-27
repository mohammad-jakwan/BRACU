import heapq
import sys
from collections import defaultdict


def solve():
    input = sys.stdin.readline
    n = int(input())
    words = [input().strip() for _ in range(n)]

    # * Building the graph.
    adj = defaultdict(set)
    in_degree = {}

    for i in range(26):
        char = chr(ord("a") + i)
        in_degree[char] = 0
    used = set()

    for char_word in words:
        used.update(char_word)  # ? update() adds elements from char_word to used set.

    for i in range(n - 1):
        word_1, word_2 = words[i], words[i + 1]
        minimum_len = min(len(word_1), len(word_2))
        found_flag = False
        for j in range(minimum_len):
            if word_1[j] != word_2[j]:
                if word_2[j] not in adj[word_1[j]]:
                    adj[word_1[j]].add(word_2[j])
                    in_degree[word_2[j]] += 1
                found_flag = True
                break

        if not found_flag and len(word_1) > len(word_2):
            print(-1)
            return

    # Initialize min heap with nodes having no incoming edges
    heap = [current for current in sorted(used) if in_degree[current] == 0]
    heapq.heapify(heap)  # ? heapify transforms the list into a heap in-place.

    #! Topological sort using Min-heap.
    result = []
    while heap:
        current = heapq.heappop(
            heap
        )  # ? heappop() removes and returns the smallest element from the heap.
        result.append(current)

        # todo: Processing neighbors in sorted order for lexicographically smallest result:
        for neighbor in sorted(adj[current]):
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                heapq.heappush(
                    heap, neighbor
                )  # ? heappush() adds an element to the heap.

    if len(result) != len(used):
        print(-1)
        return

    print("".join(result))


solve()
