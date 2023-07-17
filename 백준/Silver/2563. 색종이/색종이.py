import sys
input = sys.stdin.readline
n = int(input())
grid = [[0] * 100 for _ in range(100)]
res = 0

for _ in range(n):
    a, b = map(int, input().split())
    for i in range(a, a+10):
        for j in range(90-b, 100-b):
            grid[i][j] = 1

for i in range(100):
    for j in range(100):
        if grid[i][j] == 1:
            res += 1
print(res)