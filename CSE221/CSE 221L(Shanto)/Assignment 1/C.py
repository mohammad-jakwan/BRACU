# input and splitting
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Reversing the array
reversed_arr = arr[::-1]

# Last K elements from the reversed array
result = reversed_arr[-k:]

# Printing result as space-separated integers
print(" ".join(map(str, result)))
