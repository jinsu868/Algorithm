n, m = map(int, input().split())
bucket = [x for x in range(n+1)]

for _ in range(m):
    i, j = map(int, input().split())
    temp = bucket[i:j+1]
    bucket[i:j+1] = temp[::-1]
    
for i in range(1, n+1):
    print(bucket[i], end = ' ')