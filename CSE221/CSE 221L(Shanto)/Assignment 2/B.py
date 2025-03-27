import sys


def merge_sorted_lists(alice_list, bob_list):
    i, j = 0, 0
    merged_list = []
    while i < len(alice_list) and j < len(bob_list):
        if alice_list[i] <= bob_list[j]:
            merged_list.append(alice_list[i])
            i += 1
        else:
            merged_list.append(bob_list[j])
            j += 1
    while i < len(alice_list):
        merged_list.append(alice_list[i])
        i += 1
    while j < len(bob_list):
        merged_list.append(bob_list[j])
        j += 1
    return merged_list


input = sys.stdin.read
data = input().split()

N = int(data[0])
alice_list = list(map(int, data[1 : N + 1]))

M = int(data[N + 1])
bob_list = list(map(int, data[N + 2 : N + 2 + M]))

result = merge_sorted_lists(alice_list, bob_list)
print(" ".join(map(str, result)))
