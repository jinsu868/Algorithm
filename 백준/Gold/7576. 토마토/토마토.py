import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if g[ny][nx] == 0:
                g[ny][nx] = g[y][x] + 1
                q.append((ny, nx))

m, n = map(int ,input().split())
g = []
q = deque()
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
flagZ = False

for _ in range(n):
    g.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if g[i][j] == 1:
            q.append((i, j))
        elif g[i][j] == 0:
            flagZ = True
        
if flagZ == False:
    print(0)
else:
    bfs()
    res = 0
    flag = False
    for i in range(n):
        for j in range(m):
            if g[i][j] == 0:
                flag = True
            if g[i][j] > res:
                res = g[i][j]
    if flag == True:
        print(-1)
    else:
        print(res-1)