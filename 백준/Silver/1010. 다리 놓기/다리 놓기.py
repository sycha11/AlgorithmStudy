from math import factorial
for i in range(int(input())):
    k, n = map(int, input().split())
    result = factorial(n) // (factorial(k) * factorial(n - k))
    print(result)
