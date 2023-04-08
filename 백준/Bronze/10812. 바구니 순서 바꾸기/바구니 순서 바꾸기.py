import sys
input = sys.stdin.readline

n, m = map(int, input().split())
basket = [x for x in range(1, n+1)]

for _ in range(m):
    i, j, k = map(int, input().split())
    i, j, k = i-1, j-1, k-1
    midToEnd = basket[k:j+1]
    beginToMidMinusOne = basket[i:k]
    basket[i:i+(j-k+1)] = midToEnd
    basket[i+(j-k+1):j+1] = beginToMidMinusOne

for x in basket:
    print(x, end = ' ')