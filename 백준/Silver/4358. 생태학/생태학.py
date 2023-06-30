import sys
input = sys.stdin.readline
d = {}
total = 0
while True:
    tree = input().rstrip()
    if tree == '':
        break

    total += 1
    if tree in d:
        d[tree] += 1
    else:
        d[tree] = 1

d = sorted(d.items(), key = lambda x : x[0])

for k, v in d:
    print('%s %.4f' %(k, (v/total)*100))