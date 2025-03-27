import sys


def bisect_left(a, x):
    # Insertion point for x in a to sorted order position.
    lo, hi = 0, len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if a[mid] < x:
            lo = mid + 1
        else:
            hi = mid
    return lo


def bisect_right(a, x):
    # Insertion point for x in a to sorted order position.
    lo, hi = 0, len(a)
    while lo < hi:
        mid = (lo + hi) // 2
        if a[mid] <= x:
            lo = mid + 1
        else:
            hi = mid
    return lo


def counting_numbers_in_range(arr, queries):
    # * Creating a dictionary
    freq = {}
    for num in arr:
        if num in freq:
            freq[num] += 1
        else:
            freq[num] = 1

    # ? Sorted list of unique elements.
    unique_sorted = sorted(freq.keys())

    # TODO: storing the cumulative frequency of elements.
    prefix_sum = [0] * (len(unique_sorted) + 1)
    for i, num in enumerate(unique_sorted):
        prefix_sum[i + 1] = prefix_sum[i] + freq[num]

    results = []
    for x, y in queries:
        left = bisect_left(unique_sorted, x)
        right = bisect_right(unique_sorted, y)
        results.append(prefix_sum[right] - prefix_sum[left])
    return results


input = sys.stdin.read
data = input().split()
n = int(data[0])  # * Number of elements in the array.
q = int(data[1])  # * Number of queries.
arr = list(map(int, data[2 : n + 2]))
queries = []
for i in range(q):
    x = int(data[n + 2 + 2 * i])
    y = int(data[n + 3 + 2 * i])
    queries.append((x, y))
results = counting_numbers_in_range(arr, queries)
for result in results:
    print(result)
