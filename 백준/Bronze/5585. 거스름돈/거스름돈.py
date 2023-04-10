n = int(input())
n = 1000 - n
r = [500, 100, 50, 10, 5, 1]
res = 0

for x in r:
    res += n // x
    n %= x

print(res)