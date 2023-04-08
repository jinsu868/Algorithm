import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    r, s = input().split()
    r = int(r)
    for x in s:
        for _ in range(r):
            print(x, end = '')
    print()