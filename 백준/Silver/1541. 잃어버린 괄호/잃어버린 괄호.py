f = input()
i = 0
num = 0
res = 0
flag = False

while i < len(f):
    if f[i] == '-':
        if num != 0:
            if flag == True:
                res -= num
            else:
                res += num
        flag = True
        num = 0
    elif f[i] == '+':
        if num != 0:
            if flag == True:
                res -= num
            else:
                res += num
        num = 0
    else:
        num *= 10
        num += int(f[i])
    i += 1

if num != 0:
    if flag == True:
        res -= num
    else:
        res += num
    
print(res)