
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
t = list(map(int, input().split()))
s = max(t)
e = sum(t)
res = 0

while s <= e:
    mid = (s + e) // 2
    cnt = 0
    temp = 0
    for i in range(n):
        if temp + t[i] > mid:
            temp = 0
            cnt += 1
        temp += t[i]
        
    cnt += 1
    
    if cnt > m: 
        s = mid + 1
    elif cnt <= m:
        e = mid - 1
        res = mid

print(res)
        