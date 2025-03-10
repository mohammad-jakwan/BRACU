def build_post_order(in_order, pre_order):

    # ? Create a dictionary to find out the index of any value in the in-order traversal.
    in_order_index = {value: idx for idx, value in enumerate(in_order)}

    def tree_construction(in_start, in_end, pre_start):
        #! Base case: no elements == return empty list.
        if in_start > in_end:
            return []

        # * The first element in the pre-order traversal is the root.
        root = pre_order[pre_start]
        root_index = in_order_index[root]  # root index in the in-order traversal
        left_subtree_size = root_index - in_start  #

        # Recursion for left & right subtrees.
        left_subtree_post_order = tree_construction(
            in_start, root_index - 1, pre_start + 1
        )
        right_subtree_post_order = tree_construction(
            root_index + 1, in_end, pre_start + 1 + left_subtree_size
        )

        # TODO: Post-order traversal --> concatenation of the left subtree, right subtree, and the root.
        return left_subtree_post_order + right_subtree_post_order + [root]

    # Start the recursive construction
    return tree_construction(0, len(in_order) - 1, 0)


n = int(input())
in_order = list(map(int, input().split()))
pre_order = list(map(int, input().split()))


post_order = build_post_order(in_order, pre_order)
print(" ".join(map(str, post_order)))
