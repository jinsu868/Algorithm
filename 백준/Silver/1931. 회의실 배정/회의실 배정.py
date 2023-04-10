n = int(input())
m = []
res = 1

for _ in range(n):
    m.append(list(map(int, input().split())))
m.sort(key = lambda x: (x[1], x[0]))

end = m[0][1]

for i in range(1, n):
    if end <= m[i][0]:
        res += 1
        end = m[i][1]

print(res)