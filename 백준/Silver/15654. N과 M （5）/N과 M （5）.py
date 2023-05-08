import sys
input = sys.stdin.readline
n, m = map(int, input().split())
temp = list(map(int, input().split()))
temp.sort()
l = []
for i in range(n):
    l.append([temp[i], False])
s = []

def dfs():
    if len(s) == m:
        for x in s:
            print(x, end = ' ')
        print()
    else:
        for i in range(len(l)):
            if l[i][1] == False:
                l[i][1] = True
                s.append(l[i][0])
                dfs()
                l[i][1] = False
                s.pop()
dfs()
