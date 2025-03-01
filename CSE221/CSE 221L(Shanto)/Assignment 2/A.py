def finding_pair_for_sum(N, S, arr):
    left = 0
    right = N - 1

    while left < right:
        current_sum = arr[left] + arr[right]
        if current_sum == S:
            return left + 1, right + 1
        elif current_sum < S:
            left += 1
        else:
            right -= 1

    return -1  # ? If no pair is found we return -1.


# input & Splitting
N, S = map(int, input().split())
arr = list(map(int, input().split()))

#! Logic: The function uses a two-pointer technique to find out two numbers in the array and that adds up to variable S.
# Find and print the result
result = finding_pair_for_sum(N, S, arr)
if result == -1:
    print(result)
else:
    print(result[0], result[1])
