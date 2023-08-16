import sys
input = sys.stdin.readline
from collections import deque
n = int(input())
g = [[] for _ in range(n+1)]
deep = [-1] * (n+1)
MAX_DEPTH = 21
parent = [[1] * MAX_DEPTH for _ in range(n+1)]
q = deque()

def lcs(u, v):
    # v를 더 깊은 depth 로 설정
    if deep[u] > deep[v]:
        u, v = v, u

    for i in range(MAX_DEPTH-1, -1, -1):
        if deep[v] - deep[u] >= (2**i):
            v = parent[v][i]

    if u == v:
        return u

    for i in range(MAX_DEPTH-1, -1, -1):
        if parent[u][i] != parent[v][i]:
            u = parent[u][i]
            v = parent[v][i]

    return parent[v][0]

for _ in range(n-1):
    u, v = map(int, input().split())
    g[u].append(v)
    g[v].append(u)

q.append(1)
while q:
    deep[1] = 0
    while q:
        cur = q.popleft()
        for next in g[cur]:
            if deep[next] == -1:
                parent[next][0] = cur
                deep[next] = deep[cur] + 1
                q.append(next)


for i in range(1, MAX_DEPTH): # parent[j][i] 번째 값 세팅
    for j in range(1, n+1): # 모든 노드에 대해서
        parent[j][i] = parent[parent[j][i-1]][i-1]

m = int(input())
for _ in range(m):
    u, v = map(int, input().split())
    print(lcs(u, v))
