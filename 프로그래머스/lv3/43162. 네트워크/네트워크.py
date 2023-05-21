def dfs(v, visit, g):
    visit[v] = True
    for u in g[v]:
        if visit[u] == False:
            dfs(u, visit, g)

def solution(n, computers):
    g = [[] for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                g[i].append(j)
    
    res = 0
    visit = [False] * (n)
    
    for i in range(0, n):
        if visit[i] == False:
            res += 1
            dfs(i, visit, g)
    return res