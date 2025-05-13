class DS: # Disjoint Set.
    def __init__(self, n):
        self.parent = list(
            range(n + 1)
        )  # ! Each person has their own set with size 1 and +1 because people are numbered from 1.
        self.size = [1] * (n + 1)  # * array initialization with 1;

    def find(self, x):
        # link: http://www.shafaetsplanet.com/?p=763
        # TODO: Finding the Root/Representative of the set with path compression.
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # * Path compression.
        return self.parent[x]

    def union(self, x, y):
        # Merging two sets and returning the size of the set.
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            # TODO: Union by size:-
            # ! we add smaller tree under root of a larger tree.
            if self.size[root_x] < self.size[root_y]:
                root_x, root_y = root_y, root_x

            self.parent[root_y] = root_x
            self.size[root_x] += self.size[root_y]

        return self.size[root_x]  # Combined set size.


def Friendship():
    # * N = number of people.
    # * K = number of friendships.
    N, K = map(int, input().split())

    # Data structure.
    algo_structure = DS( # Disjoint Set.N)

    # Friendship check for each pair of friends.
    for _ in range(K):
        a, b = map(int, input().split())
        print(
            algo_structure.union(a, b)
        )  # ? .union(a, b) returns the size of the set after union.


# 8 7               2
# 2 4               3
# 4 5               2
# 3 6               4
# 4 7               3
# 3 1               4
# 2 7               7
# 6 2


Friendship()
