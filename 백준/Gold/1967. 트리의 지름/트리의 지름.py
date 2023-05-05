import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000000)
n = int(input())
g = [[] for _ in range(n+1)]
visit = [-1] * (n+1)

def dfs(v, w):
    for u in g[v]:
        if visit[u[0]] == -1:
            visit[u[0]] = w + u[1]
            dfs(u[0], w + u[1])

for _ in range(n-1):
    p, c, w = map(int, input().split())
    g[p].append((c, w))
    g[c].append((p, w))

visit[1] = 0
dfs(1, 0)
fIdx = visit.index(max(visit))

visit = [-1] * (n+1)
visit[fIdx] = 0
dfs(fIdx, 0)

print(max(visit))