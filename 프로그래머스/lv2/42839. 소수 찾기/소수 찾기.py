import math

def isPrime(x):
    if x == 0 or x == 1:
        return False
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True

def solution(numbers):
    g = list(numbers)
    l = len(g)
    d = {}
    
    def dfs(v, visit, s):
        temp = int(s)
        if isPrime(temp) and temp not in d:
            d[temp] = 1
        
        for i in range(l):
            if visit[i] == False:
                visit[i] = True
                dfs(i, visit, s+g[i])
                visit[i] = False
        
    for i in range(l):
        visit = [False] * l
        visit[i] = True
        temp = int(g[i])
        if isPrime(temp) and temp not in d:
            d[temp] = 1
        dfs(i, visit, g[i])
    
    return len(d)
    