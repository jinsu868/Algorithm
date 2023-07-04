import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))
dp = li[:]
for i in range(1, n):
    for j in range(i):
        if li[i] > li[j]:
            dp[i] = max(dp[j] + li[i], dp[i])
print(max(dp))