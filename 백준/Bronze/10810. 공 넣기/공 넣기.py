n, m = map(int, input().split())
bucket = [0] * (n+1)

for _ in range(m):
    i, j, k = map(int, input().split())
    for x in range(i, j+1):
        bucket[x] = k
for i in range(1, n+1):
    print(bucket[i], end = ' ')