import sys
input = sys.stdin.readline
n = int(input())
q = n // 5
res = -1

if q == 0:
    if n % 3 == 0:
        res = n // 3
    print(res)
else:
    for i in reversed(range(q + 1)):
        if (n - i*5) % 3 == 0:
            res = (n - i*5) // 3 + i
            break
    print(res)
