import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
card = []
res = 0

for i in range(n):
    heappush(card, int(input()))
if n != 1:
    while n > 1:
        x = heappop(card)
        y = heappop(card)
        res += x+y
        heappush(card, x+y)
        n -= 1
    print(res)
else:
    print(0)


