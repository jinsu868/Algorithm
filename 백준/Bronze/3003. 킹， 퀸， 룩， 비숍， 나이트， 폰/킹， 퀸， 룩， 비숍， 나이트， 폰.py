import sys 
input = sys.stdin.readline

check = [1, 1, 2, 2, 2, 8]
foundList = list(map(int, input().split()))
for i in range(len(check)):
    print(check[i] - foundList[i], end = ' ')