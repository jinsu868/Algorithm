n, m = map(int, input().split())
bucket = [x for x in range(n+1)]
for _ in range(m):
    i, j = map(int, input().split())
    temp = bucket[i]
    bucket[i] = bucket[j]
    bucket[j] = temp

for i in range(1, n+1):
    print(bucket[i], end = ' ')