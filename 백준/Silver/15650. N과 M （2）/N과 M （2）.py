n, m = map(int, input().split())
s = []
visit = [False] * (n+1)

def dfs():
    if len(s) == m:
        for x in s:
            print(x, end = ' ')
        print()
    for i in range(1, n+1):
        if visit[i] == True:
            continue
        if len(s) != 0 and s[-1] > i:
            continue
        s.append(i)
        visit[i] = True
        dfs()
        s.pop()
        visit[i] = False
        
dfs()