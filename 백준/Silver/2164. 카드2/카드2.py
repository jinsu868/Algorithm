from collections import deque

n = int(input())
q = deque()
res = 0

for x in range(1, n+1):
    q.append(x)
    
while q:
    res = q.popleft()
    if not q:
        break
    temp = q.popleft()
    q.append(temp)
    
print(res)