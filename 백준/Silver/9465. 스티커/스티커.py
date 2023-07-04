t = int(input())
for _ in range(t):
    n = int(input())
    dp = [[0]*2 for _ in range(n)]
    li = list(map(int, input().split()))
    for i in range(n):
        dp[i][0] = li[i]
    li = list(map(int, input().split()))
    for i in range(n):
        dp[i][1] = li[i]
    if n == 1:
        print(max(dp[0]))
        continue
    dp[1][0] = dp[0][1] + dp[1][0]
    dp[1][1] = dp[0][0] + dp[1][1]
    
    for i in range(2, n):
        dp[i][0] = max(max(dp[i-2]), dp[i-1][1]) + dp[i][0]
        dp[i][1] = max(max(dp[i-2]), dp[i-1][0]) + dp[i][1]  
    print(max(dp[n-1]))