from collections import deque

INF = int(1e9)

n, k = map(int, input().split())
dist = [INF] * 100001

def bfs(v):
    q = deque()
    q.append(v)
    dist[v] = 0
    while q:
        u = q.popleft()
        if u == k:
            print(dist[u])
            break
        for v in (u-1, u+1, 2*u):
            if 0 <= v < 100001:
                if dist[v] == INF:
                    dist[v] = dist[u] + 1
                    q.append(v)
bfs(n)