import sys
input = sys.stdin.readline
n, m = map(int, input().split())
l = list(map(int, input().split()))
l.sort()
s = []

def dfs(k):
    if len(s) == m:
        for x in s:
            print(x, end = ' ')
        print()
    else:
        for i in range(k, n):
            s.append(l[i])
            dfs(i)
            s.pop()
dfs(0)