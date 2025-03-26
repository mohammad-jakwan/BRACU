def max_pair_value(arr):
    arr = [0] + arr  # Adding a dummy element at index 0
    n = len(arr) - 1  # Actual size of the array

    def divide_and_conquer(start, end):
        if end - start <= 1:
            return float("-inf")

        if end - start == 2:
            return arr[start] + arr[start + 1] ** 2

        mid = (start + end) // 2

        left_max = divide_and_conquer(start, mid)
        right_max = divide_and_conquer(mid, end)

        cross_max = float("-inf")

        max_left_val = float("-inf")
        for i in range(start, mid):
            max_left_val = max(max_left_val, arr[i])

        max_right_sq = float("-inf")
        for j in range(mid, end):
            max_right_sq = max(max_right_sq, arr[j] ** 2)

        cross_max = max_left_val + max_right_sq

        return max(left_max, right_max, cross_max)

    return divide_and_conquer(1, n + 1)


n = int(input())
arr = list(map(int, input().split()))
result = max_pair_value(arr)
print(result)
