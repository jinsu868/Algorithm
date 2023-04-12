button = [300, 60, 10]
res = [0, 0, 0]

t = int(input())

for i in range(3):
    if button[i] <= t:
        res[i] += t // button[i]
        t %= button[i]

if t == 0:
    for i in range(3):
        print(res[i], end = ' ')
else:
    print(-1)