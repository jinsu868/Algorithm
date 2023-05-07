import sys
input = sys.stdin.readline
n = int(input())
res = 0
borad = [0] * n

#대각선 -> dx = dy
def check(x):
    for i in range(x):
        if borad[i] == borad[x] or abs(x-i) == abs(borad[x]-borad[i]):
            return False
    return True

def dfs(m):
    global res
    if m == n:
        res += 1
    else:
        for i in range(n):
            borad[m] = i
            if check(m):
                dfs(m+1)
dfs(0)
print(res)