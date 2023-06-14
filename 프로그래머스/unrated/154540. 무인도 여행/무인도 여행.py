import sys
sys.setrecursionlimit(10**5)

cnt = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(g, y, x, n, m, visit):
    global cnt
    cnt += int(g[y][x])
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if visit[ny][nx] == False and g[ny][nx] != 'X':
            visit[ny][nx] = True
            dfs(g, ny, nx, n, m, visit)
            
            

def solution(maps):
    global cnt
    n = len(maps)
    m = len(maps[0])
    res = []
    visit = [[False] * m for _ in range(n)]
    
    for i in range(n):
        for j in range(m):
            if visit[i][j] == False and maps[i][j] != 'X':
                visit[i][j] = True
                cnt = 0  
                dfs(maps, i, j, n, m, visit)
                res.append(cnt)
    if len(res) == 0:
        return [-1]
    else:
        res.sort()
        return res