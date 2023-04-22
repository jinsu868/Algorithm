# 4963/섬의 개수
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [1, 1, 0, -1, -1, -1, 0, 1]

def dfs(y, x):
    g[y][x] = 0
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= w or ny >= h:
            continue
        if g[ny][nx] == 1:
            dfs(ny, nx)

while True:
    w, h = map(int, input().split())
    g = []
    res = 0
    if w == 0 or h == 0:
        break
    
    for _ in range(h):
        g.append(list(map(int, input().split())))

    for i in range(h):
        for j in range(w):
            if g[i][j] == 1:
                res += 1
                dfs(i, j)
    print(res)