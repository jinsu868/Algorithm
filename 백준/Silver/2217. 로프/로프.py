n = int(input())
rope = []
for _ in range(n):
    rope.append(int(input()))
rope.sort(reverse=True)

res = []
for i in range(n):
    res.append(rope[i]*(i+1))
print(max(res))