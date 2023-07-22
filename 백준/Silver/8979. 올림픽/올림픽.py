import sys
input = sys.stdin.readline
n, k = map(int, input().split())
findIdx = 0
li = []


for _ in range(n):
    li.append(list(map(int, input().split())))
li.sort(key = lambda x : (-x[1], -x[2], -x[3]))
for i in range(n):
    if li[i][0] == k:
        findIdx = i
        break
res = findIdx
for i in range(findIdx-1, -1, -1):
    if li[i][1] != li[findIdx][1] or li[i][2] != li[findIdx][2] or li[i][3] != li[findIdx][3]:
        res = i
        break

if res == findIdx:
    print(1)
else:
    print(res+2)
