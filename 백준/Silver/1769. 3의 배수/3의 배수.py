# 1769

n = input()
res = 0

while len(n) > 1:
    res += 1
    temp = 0
    for x in n:
        temp += int(x)
    n = str(temp)

print(res)
if int(n) % 3 == 0:
    print('YES')
else:
    print('NO')