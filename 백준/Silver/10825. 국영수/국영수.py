import sys
input = sys.stdin.readline
n = int(input())
li = []
for _ in range(n):
    name, kor, eng, math = input().split()
    li.append((name, int(kor), int(eng), int(math)))
li.sort(key = lambda x : (-x[1], x[2], -x[3], x[0]))

for i in range(n):
    print(li[i][0])