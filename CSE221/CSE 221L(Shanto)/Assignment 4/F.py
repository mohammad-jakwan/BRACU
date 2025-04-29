def get_valid_moves(N, x, y):
    # * All possible moves for the king (dx, dy) in a list of tuples.
    directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    valid_moves = []

    # TODO: for each possible move
    for dx, dy in directions:
        new_x = x + dx
        new_y = y + dy

        #! if the new position is within neighbourhood, also within the board boundaries:
        if 1 <= new_x <= N and 1 <= new_y <= N:
            valid_moves.append((new_x, new_y))

    # ? moves while following the given condition.
    valid_moves.sort()
    return valid_moves


N = int(input())
x, y = map(int, input().split())
moves = get_valid_moves(N, x, y)
print(len(moves))
for move in moves:
    print(move[0], move[1])
