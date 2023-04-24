import sys
input = sys.stdin.readline
for i in range(1, 10001):
    flag = True
    for j in range(1, i+1):
        total = j
        temp = j
        while temp:
            total += temp % 10
            temp = temp // 10
        if total == i:
            flag = False
            break
    if flag == True:
        print(i)