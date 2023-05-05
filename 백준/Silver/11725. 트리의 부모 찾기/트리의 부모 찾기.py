import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)
n = int(input())
g = [[] for _ in range(n+1)]
parent = [0] * (n+1)

def dfs(p, v):
    parent[v] = p
    
    for u in g[v]:
        if parent[u] == 0:
            dfs(v, u)

for _ in range(n-1):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)
    
dfs(1, 1)

for i in range(2, n+1):
    print(parent[i])