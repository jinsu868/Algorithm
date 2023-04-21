import sys
input = sys.stdin.readline
import heapq

INF = int(1e9)
n, m = map(int, input().split())
s = int(input())
g = [[] for _ in range(n+1)]
dist = [INF] * (n+1)

def dijkstra(s):
    q = []
    heapq.heappush(q, (0, s))
    dist[s] = 0
    
    while q:
        d, u = heapq.heappop(q)
        if dist[u] < d:
            continue
        for v in g[u]:
            if dist[v[0]] > d + v[1]:
                dist[v[0]] = d + v[1]
                heapq.heappush(q, (dist[v[0]], v[0]))
            
for _ in range(m):
    u, v, w = map(int, input().split())
    g[u].append((v, w))
    
dijkstra(s)

for i in range(1, n+1):
    if dist[i] == INF:
        print("INF")
    else:
        print(dist[i])