import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
def dfs(y, x):
    g[y][x] = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if g[ny][nx] == 1:
            dfs(ny, nx)
        
t = int(input())
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for _ in range(t):
    res = 0
    m, n, p = map(int, input().split())
    g = [[0] * (m) for _ in range(n)]
    for _ in range(p):
        x, y = map(int, input().split())
        g[y][x] = 1
    for i in range(n):
        for j in range(m):
            if g[i][j] == 1:
                res += 1
                dfs(i, j)
    print(res)