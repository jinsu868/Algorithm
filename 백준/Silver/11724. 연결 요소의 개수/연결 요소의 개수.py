import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

n, m = map(int, input().split())
g = [[] for _ in range(n+1)]
visit = [False] * (n+1)
res = 0

def dfs(v):
    visit[v] = True
    for u in g[v]:
        if visit[u] == False:
            dfs(u)

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)
    
for i in range(1, n+1):
    if visit[i] == False:
        res += 1
        dfs(i)
        
print(res)
