import sys


def finding_first_index(S):
    left, right = 0, len(S) - 1
    result = -1  # When no 1 is found.

    while left <= right:
        mid_idx = (left + right) // 2
        if S[mid_idx] == "1":
            result = mid_idx + 1  # 1-based indexing.
            right = mid_idx - 1
        else:
            left = mid_idx + 1
    return result


input = sys.stdin.read
data = input().split()
T = int(data[0])  # Number of test cases.

index = 1
for _ in range(T):
    S = data[index]
    result = finding_first_index(S)
    print(result)
    index += 1
