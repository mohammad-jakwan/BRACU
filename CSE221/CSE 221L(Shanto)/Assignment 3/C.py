def fast_mod_drift(a, b, mod):
    result = 1
    while b > 0:
        if b % 2 == 1:
            result = (result * a) % mod
        a = (a * a) % mod
        b = b // 2
    return result


a, b = map(int, input().split())
result = fast_mod_drift(a, b, 107)
print(result)
