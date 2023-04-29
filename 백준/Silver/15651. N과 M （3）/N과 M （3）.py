n, m = map(int, input().split())
s = []

def dfs():
    if len(s) == m:
        for x in s:
            print(x, end = ' ')
        print()
        return
    for i in range(1, n+1):
        s.append(i)
        dfs()
        s.pop()
        
dfs()