from collections import deque
def solution(maps):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    n = len(maps)
    m = len(maps[0])
    INF = int(1e9)
    dist = [[INF] * m for _ in range(n)]
    dist[0][0] = 1
    q = deque()
    q.append((0, 0))
    
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if maps[ny][nx] == 0:
                continue
            if dist[ny][nx] == INF:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))
    
    if dist[n-1][m-1] == INF:
        return -1
    else:
        return dist[n-1][m-1]
    
    
   
