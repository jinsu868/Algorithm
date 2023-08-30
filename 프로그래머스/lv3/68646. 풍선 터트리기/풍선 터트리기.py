def solution(a):
    INF = int(1e9)
    l = len(a)
    dp = [[INF] * 2 for _ in range(l)]
    res = 0

    for i in range(1, l):
        dp[i][0] = min(dp[i-1][0], a[i-1])
    for i in range(l-2, -1, -1):
        dp[i][1] = min(dp[i+1][1], a[i+1])

    for i in range(l):
        if dp[i][0] < a[i] and dp[i][1] < a[i]:
            continue
        else:
            res += 1
    return res