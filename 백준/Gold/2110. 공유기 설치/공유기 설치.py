import sys
input = sys.stdin.readline

n, c = map(int, input().split())
x = []
res = 0

for _ in range(n):
    x.append(int(input()))

x.sort()

s = 1
e = x[-1] - x[0]


while s <= e:
    mid = (s + e) // 2
    cur = x[0]
    cnt = 1
    
    for i in range(1, len(x)):
        if x[i] >= cur + mid:
            cnt += 1
            cur = x[i]
    if cnt >= c:
        res = mid
        s = mid+1
    else:
        e = mid-1
print(res)