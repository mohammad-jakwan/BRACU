# Input and splitting the values.
N = int(input())
ids = list(map(int, input().split()))
marks = list(map(int, input().split()))

swaps = 0  # * counter for swaps.

# TODO: Using Selection Sort methods for lowest swaps.
# outer loop goes through each student.

for i in range(N):
    min_idx = i  # ? track of the position; of students with the highest marks (or lowest ids if marks are the same).
    for j in range(i + 1, N):
        if marks[j] > marks[min_idx] or (
            marks[j] == marks[min_idx] and ids[j] < ids[min_idx]
        ):
            min_idx = j

    #! If Highest marks is not already in the correct position then we swaps the students.
    if min_idx != i:
        marks[i], marks[min_idx] = marks[min_idx], marks[i]
        ids[i], ids[min_idx] = ids[min_idx], ids[i]
        swaps += 1

print(f"Minimum swaps: {swaps}")
for i in range(N):
    print(f"ID: {ids[i]} Mark: {marks[i]}")
