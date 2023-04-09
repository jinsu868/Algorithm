import sys
input = sys.stdin.readline
n = int(input())
count = 0

for _ in range(n):
    s = input()
    l = len(s)
    flag = False
    temp = [s[0]]
    for i in range(1, l):
        if s[i] == temp[-1]:
            continue
        else:
            if s[i] in temp:
                flag = True
                break
            else:
                temp.append(s[i])
    if flag == False:
        count += 1

print(count)