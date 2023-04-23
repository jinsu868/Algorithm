n = int(input())
pos = list(map(int, input().split()))
uPos = list(set(pos))
uPos.sort()
d = {}
for i in range(len(uPos)):
    d[uPos[i]] = i
for i in range(n):
    print(d[pos[i]], end = ' ')