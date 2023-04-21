import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
grid = []
n = int(input())
visit1 = [[0]*n for _ in range(n)]
visit2 = [[0]*n for _ in range(n)]

cur1 = 'T'
cur2 = 'T'
res = [0, 0]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def dfs(y, x):
    visit1[y][x] = 1
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if visit1[ny][nx] == 0 and grid[ny][nx] == cur1:
            dfs(ny, nx)

def dfs2(y, x):
    visit2[y][x] = 1
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if visit2[ny][nx] != 0:
            continue
        if cur2 == 'B':
            if grid[ny][nx] == cur2:
                dfs2(ny, nx)
        else:
            if grid[ny][nx] != 'B':
                dfs2(ny, nx)
    
for _ in range(n):
    grid.append(list(input()))

for i in range(n):
    for j in range(n):
        if visit1[i][j] == 0:
            res[0] += 1
            cur1 = grid[i][j]
            dfs(i, j)
        if visit2[i][j] == 0:
            res[1] += 1
            cur2 = grid[i][j]
            dfs2(i, j)

print(res[0], res[1])