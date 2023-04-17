import sys
input = sys.stdin.readline
from collections import deque

INF = int(1e9)
n, m, s = map(int, input().split())
g = [[] for _ in range(n+1)]
visit = [False] * (n+1)
visit1 = [False] * (n+1)

def bfs(v):
    q = deque()
    q.append(v)
    visit[v] = True
    
    while q:
        u = q.popleft()
        print(u, end = ' ')
        for x in g[u]:
            if visit[x] == False:
                visit[x] = True
                q.append(x)
        
def dfs(v):
    print(v, end = ' ')
    visit1[v] = True
    
    for x in g[v]:
        if visit1[x] == False:
            dfs(x)
        
for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

for i in range(1, n+1):
    g[i].sort()

dfs(s)
print()
bfs(s)