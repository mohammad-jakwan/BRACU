def creation_of_binary_search_tree(arr, left, right, result):
    if left > right:
        return

    mid = (left + right) // 2
    result.append(arr[mid])

    #! Recursion for the left and right subtrees.
    creation_of_binary_search_tree(arr, left, mid - 1, result)
    creation_of_binary_search_tree(arr, mid + 1, right, result)


def bst_pre_order_traversal(N, arr):
    result = []
    creation_of_binary_search_tree(arr, 0, N - 1, result)
    return result


N = int(input().strip())
arr = list(map(int, input().strip().split()))

pre_order_result = bst_pre_order_traversal(N, arr)

print(" ".join(map(str, pre_order_result)))
