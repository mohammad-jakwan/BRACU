import sys


# * K is the target sum for the sub-array.
def longest_sub__array_with_sum_at_k(N, K, arr):
    start = 0
    current_sum = 0
    max_length_any_sub_array = 0  #!  any sub-array found with a sum equal to ( K ).

    for end in range(N):
        current_sum += arr[end]

        while current_sum > K:
            current_sum -= arr[start]
            start += 1

        max_length_any_sub_array = max(max_length_any_sub_array, end - start + 1)

    return max_length_any_sub_array


input = sys.stdin.read
data = input().split()
N = int(data[0])
K = int(data[1])
arr = list(map(int, data[2:]))
result = longest_sub__array_with_sum_at_k(N, K, arr)
print(result)
