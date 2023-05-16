# 1932
import sys
input = sys.stdin.readline
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

w = 2
for i in range(1, n):
    for j in range(w):
        if j == 0: 
            arr[i][j] = arr[i-1][0] + arr[i][j]
        elif i == j:
            arr[i][j] = arr[i-1][j-1] + arr[i][j]
        else:
            arr[i][j] = max(arr[i-1][j-1], arr[i-1][j]) + arr[i][j]
    w += 1

print(max(arr[n-1]))