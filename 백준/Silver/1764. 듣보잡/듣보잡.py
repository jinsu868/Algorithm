n, m = map(int, input().split())
a = set()
b = set()
res = []
for _ in range(n):
    a.add(input())
for _ in range(m):
    b.add(input())

res = list(a & b)
res.sort()

print(len(res))
for x in res:
    print(x)