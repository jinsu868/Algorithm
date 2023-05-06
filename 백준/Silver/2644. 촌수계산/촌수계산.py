import sys
input = sys.stdin.readline
INF = int(1e9)
from collections import deque
n = int(input())
a, b = map(int, input().split())
m = int(input())
g = [[] for _ in range(n+1)]
d = [INF] * (n+1)

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

def bfs():
    d[a] = 0
    q = deque()
    q.append(a)
    
    while q:
        u = q.popleft()
        for v in g[u]:
            if d[v] == INF:
                d[v] = d[u] + 1
                q.append(v)

bfs()
if d[b] == INF:
    print(-1)
else:
    print(d[b])
