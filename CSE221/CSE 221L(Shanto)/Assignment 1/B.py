# Reading number of test cases.
T = int(input())

# * How many time each test case will be checked.
for _ in range(T):
    # ! Spiting single line
    calculate = input().split()

    # ? Skipping "calculate" word to get first num using ternary operator.
    starting_index = 1 if calculate[0] == "calculate" else 0

    # * Fetching Operands and Operator from split.
    x = int(calculate[starting_index])
    operator = calculate[starting_index + 1]
    y = int(calculate[starting_index + 2])

    # TODO: Conditions for Arithmetic operations.
    if operator == "+":
        result = x + y
    elif operator == "-":
        result = x - y
    elif operator == "*":
        result = x * y
    elif operator == "/":
        result = x / y

    print(f"{result:.6f}")
