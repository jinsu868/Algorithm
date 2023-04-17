
from collections import deque

n, m = map(int, input().split())
g = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(y, x):
    q = deque()
    q.append((y, x))
    
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or ny >= n or nx < 0 or nx >= m:
                continue
            if g[ny][nx] == 0 or g[ny][nx] > 1:
                continue
            
            g[ny][nx] = g[y][x]+1
            q.append((ny, nx))
    

for _ in range(n):
    g.append(list(map(int, input())))
    
bfs(0, 0)
print(g[n-1][m-1])