n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    swapping_flag = False
    # Iterating through the array up to the unsorted portion
    for j in range(0, n - i - 1):
        #! When the current element is greater than the next element we swap them.
        if arr[j] > arr[j + 1]:
            arr[j], arr[j + 1] = arr[j + 1], arr[j]
            swapping_flag = True
    if not swapping_flag:
        break

print(" ".join(map(str, arr)))
