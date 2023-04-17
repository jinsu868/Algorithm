import sys
input = sys.stdin.readline
n = int(input())
pos = []
for _ in range(n):
    pos.append(list(map(int, input().split())))
pos.sort(key=lambda x: (x[1], x[0]))

for i in range(n):
    print(pos[i][0], pos[i][1])