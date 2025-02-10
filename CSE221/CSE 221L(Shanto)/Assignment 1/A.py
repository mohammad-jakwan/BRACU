T = int(input())

N = [int(input()) for i in range(T)]

for _ in N:
    if n % 2 == 0:
        print(f"{n} is an Even number.")
    else:
        print(f"{n} is an Odd number.")
