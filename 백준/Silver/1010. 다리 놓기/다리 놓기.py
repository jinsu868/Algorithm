import math

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    # mCn
    print(math.comb(m, n))