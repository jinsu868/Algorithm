from collections import deque
import sys
import copy
input = sys.stdin.readline

n, m = map(int, input().split())
grid = []
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
result = 0

for _ in range(n):
    grid.append(list(map(int, input().split())))

def bfs():
    q = deque()
    copyGrid = copy.deepcopy(grid)
    for i in range(n):
        for j in range(m):
            if copyGrid[i][j] == 2:
                q.append((i, j))
    
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or ny >= n or nx < 0 or nx >= m:
                continue
            if copyGrid[ny][nx] == 0:
                copyGrid[ny][nx] = 2
                q.append((ny,nx))
        
    global result
    count = 0
    for i in range(n):
        for j in range(m):
            if copyGrid[i][j] == 0:
                count += 1
    result = max(count, result)

def wall(count):
    if count == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 0:
                grid[i][j] = 1
                wall(count+1)
                grid[i][j] = 0

wall(0)
print(result)