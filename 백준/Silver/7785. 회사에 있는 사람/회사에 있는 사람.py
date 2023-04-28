import sys
input = sys.stdin.readline
n = int(input())
p = {}
for _ in range(n):
    name, c = input().split()
    if c == 'enter':
        p[name] = 1
    elif c == 'leave':
        del(p[name])
p = list(p)
p.sort(reverse = True)

for x in p:
    print(x)