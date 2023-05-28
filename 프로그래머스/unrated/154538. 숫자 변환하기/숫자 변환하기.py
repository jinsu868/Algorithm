from collections import deque
def solution(x, y, n):
    INF = int(1e9)
    dist = [INF] * (y+1)
    dist[x] = 0
    q = deque()
    q.append((x, 0))
    
    while q:
        u, d = q.popleft()
        for v in [u*2, u*3, u+n]:
            if v > y:
                continue
            if dist[v] > d + 1:
                dist[v] = d +1
                q.append((v, d+1))
    
    if dist[y] == INF:
        return -1
    else:
        return dist[y]