# 2156
import sys
input = sys.stdin.readline
n = int(input())
dp = [0] * 10000
arr = []

for _ in range(n):
    arr.append(int(input()))

if n == 1:
    print(arr[0])
elif n == 2:
    print(arr[0] + arr[1])
elif n == 3:
    print(max(arr[1] + arr[2], arr[0] + arr[2], arr[0] + arr[1]))
else:
    dp[0] = arr[0]    
    dp[1] = arr[0] + arr[1]
    dp[2] = max(arr[1] + arr[2], arr[0] + arr[2], arr[0] + arr[1])
    for i in range(3, n):
        dp[i] = max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i], dp[i-1])
    print(dp[n-1])