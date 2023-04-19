import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
q = deque()

for _ in range(n):
    temp = input().split()
    
    if temp[0] == "push":
        q.append(int(temp[1]))
    elif temp[0] == "pop":
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
    elif temp[0] == "size":
        print(len(q))
    elif temp[0] == "empty":
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif temp[0] == "front":
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif temp[0] == "back":
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])