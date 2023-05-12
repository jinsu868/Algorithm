import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)
n, m = map(int, input().split())
g = []
res = 0
dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]

for _ in range(n):
    g.append(list(map(int, input().split())))
    
def dfs(y, x):
    if y == n-1 and x == m-1:
        return 1
    
    if dp[y][x] == -1:
        dp[y][x] = 0
        for i in range(4):
            ny = dy[i] + y
            nx = dx[i] + x
            if ny < 0 or ny >= n or nx < 0 or nx >= m:
                continue
            if g[y][x] > g[ny][nx]:
                dp[y][x] += dfs(ny, nx)
    return dp[y][x]
    
dp = [[-1] * m for _ in range(n)]
print(dfs(0, 0))
