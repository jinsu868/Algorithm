import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
g = [[] for _ in range(n+1)]
visit = [False] * (n+1)
res = 0

def dfs(v):
    global res
    res += 1
    visit[v] = True
    
    for u in g[v]:
        if visit[u] == False:
            dfs(u)

for _ in range(m):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)
    
dfs(1)
print(res-1)