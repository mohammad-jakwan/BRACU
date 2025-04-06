def fast_mod(a, b, m):

    result = 1
    a %= m
    while b:
        if b & 1:
            result = (result * a) % m
        a = (a * a) % m
        b >>= 1
    return result


def mod_inverse(a, m):
    def gcd(a: int, b: int) -> tuple:
        if not a:
            return b, 0, 1
        gcd, x1, y1 = gcd(b % a, a)
        x = y1 - (b // a) * x1
        return gcd, x, x1

    X_X, x, X_X = gcd(a, m)
    return (x % m + m) % m


def sum_powers_mod(a, n, m):
    if a >= m:
        a %= m
    if a <= 1:
        return (n * a) % m
    if n == 1:
        return a

    power = fast_mod(a, n + 1, m)
    numerator = (power - a + m) % m
    denominator = mod_inverse((a - 1 + m) % m, m)

    return (numerator * denominator) % m


T = int(input().strip())
for _ in range(T):
    a, n, m = map(int, input().strip().split())
    result = sum_powers_mod(a, n, m)
    print(result)
