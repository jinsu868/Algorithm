n = int(input())
li = list(map(int, input().split()))
dp = [[1]*2 for _ in range(n)]
for i in range(n):
    for j in range(i):
        if li[i] > li[j]:
            dp[i][0] = max(dp[i][0], dp[j][0]+1)
for i in range(n-1, -1, -1):
    for j in range(n-1, i, -1):
        if li[i] > li[j]:
            dp[i][1] = max(dp[i][1], dp[j][1]+1)
res = 0    
for i in range(n):
    cur = dp[i][0] + dp[i][1] - 1
    if cur > res:
        res = cur
print(res)