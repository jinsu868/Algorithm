import sys
input = sys.stdin.readline
n, m = map(int, input().split())
th = list(map(int, input().split()))
s = 0
e = max(th)
res = 0

while s <= e:
    mid = (s + e) // 2
    g = 0
    for h in th:
        if mid < h:
            g += h - mid
    if g >= m: 
        res = mid
        s = mid + 1
    else:
        e = mid - 1
    
print(res)