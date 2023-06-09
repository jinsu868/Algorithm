from collections import deque
def solution(n, edge):
    g = [[] for _ in range(n+1)]
    
    for e in edge:
        g[e[0]].append(e[1])
        g[e[1]].append(e[0])
    
    q = deque()
    INF = int(1e9)
    dist = [INF] * (n+1)
    dist[1] = 0
    q.append((1, 0))
    
    while q:
        u, d = q.popleft()
        for v in g[u]:
            if dist[v] == INF:
                dist[v] = d + 1
                q.append((v, dist[v]))
    
    mv = 0
    for i in range(2, n+1):
        if dist[i] == INF:
            continue
        if dist[i] > mv:
            mv = dist[i]
    
    print(dist)
    return dist.count(mv)
    