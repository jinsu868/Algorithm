import sys
input = sys.stdin.readline
k, n = map(int, input().split())
l = []
res = 0

for _ in range(k):
    l.append(int(input()))
    
e = max(l)
s = 1

while s <= e:
    mid = (s + e) // 2
    m = 0
    for i in l:
        m += i // mid
    if m >= n:
        res = mid
        s = mid + 1
    else:
        e = mid-1
        
print(res)