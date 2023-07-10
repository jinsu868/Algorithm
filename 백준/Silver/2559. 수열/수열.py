import sys
input = sys.stdin.readline
n, k = map(int, input().split())
li = list(map(int, input().split()))

p_sum = sum(li[:k])
res = p_sum

for i in range(n-k):
    p_sum += li[i+k] - li[i]
    if p_sum > res:
        res = p_sum
print(res)