def solve():
    # Input Reading: N (nodes) and M (edges).
    N, M = map(int, input().split())

    # If M is 0, we handle the empty graph.
    if M == 0:
        for i in range(1, N + 1):
            print(f"{i}:")
        return

    u = list(map(int, input().split()))  # ? source nodes
    v = list(map(int, input().split()))  # ? destination nodes
    w = list(map(int, input().split()))  # ? weights

    # TODO: adjacency list representation:
    # * Initialize empty lists for each node (1-based indexing);
    adj_list = [[] for item in range(N + 1)]

    # Filling the adjacency list while maintaining input order.
    for i in range(M):
        source = u[i]
        destination = v[i]
        weight = w[i]
        adj_list[source].append((destination, weight))

    for i in range(1, N + 1):
        print(f"{i}:", end="")
        if adj_list[i]:  # ! If node has edges
            for destination, weight in adj_list[i]:
                print(f" ({destination},{weight})", end="")
        print()


solve()
