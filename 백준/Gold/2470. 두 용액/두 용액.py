import sys
input = sys.stdin.readline

n = int(input())
l = list(map(int, input().split()))
INF = int(1e9)

s = 0
e = n-1
res = sys.maxsize
ans = [-1, -1]

l.sort()

while s < e:
    temp = l[s] + l[e]
    if abs(res) > abs(temp):
        res = abs(temp)
        ans[0] = l[s]
        ans[1] = l[e]

    elif temp >= 0:
        e -= 1
    else:
        s += 1
        
print(ans[0], ans[1])