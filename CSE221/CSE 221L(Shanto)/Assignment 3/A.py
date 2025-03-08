def merge_count(arr, temp_array, left, mid, right):
    i = left  # Starting index of the left sub-array.
    j = mid + 1  # Starting index for the right sub-array.
    k = left  # Starting index to be sorted.
    inverse_count = 0

    # * Merging two sub-array and counting inversions.
    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp_array[k] = arr[i]
            i += 1
        else:
            # TODO: There is (mid - i + 1) inversions cause all the remaining elements is in the left sub-array are > arr[j];
            temp_array[k] = arr[j]
            inverse_count += mid - i + 1
            j += 1
        k += 1

    # ? remaining elements of the left sub-array:
    while i <= mid:
        temp_array[k] = arr[i]
        i += 1
        k += 1

    # ? remaining elements of the right sub-array:
    while j <= right:
        temp_array[k] = arr[j]
        j += 1
        k += 1

    # temp sorted sub-array into the original array.
    for i in range(left, right + 1):
        arr[i] = temp_array[i]

    return inverse_count


def mg_short_cunt(arr, temp_array, left, right):

    inverse_count = 0
    if left < right:
        mid = (left + right) // 2

        # Count inversions in the left, right sub-array.
        inverse_count += mg_short_cunt(arr, temp_array, left, mid)
        inverse_count += mg_short_cunt(arr, temp_array, mid + 1, right)

        #! Count split inversions and merge the two sub-arrays.
        inverse_count += merge_count(arr, temp_array, left, mid, right)

    return inverse_count


# Input and splitting
n = int(input())
arr = list(map(int, input().split()))
temp_array = [0] * n
inversion_count = mg_short_cunt(arr, temp_array, 0, n - 1)

print(inversion_count)
print(" ".join(map(str, arr)))
