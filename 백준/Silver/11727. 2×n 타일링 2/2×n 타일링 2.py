# 11727
import sys
input = sys.stdin.readline

dp = [0] * 1001
dp[1] = 1
dp[2] = 3

n = int(input())

for i in range(3, n+1):
    if i % 2 == 0:
        dp[i] = (dp[i-1] * 2 + 1) % 10007
    else:
        dp[i] = (dp[i-1] * 2 - 1) % 10007
print(dp[n])