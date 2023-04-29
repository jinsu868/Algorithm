n, m = map(int, input().split())
s = []

def dfs(v):
    if len(s) == m:
        for x in s:
            print(x, end = ' ')
        print()
        return
    for i in range(v, n+1):
        s.append(i)
        dfs(i)
        s.pop()

dfs(1)       