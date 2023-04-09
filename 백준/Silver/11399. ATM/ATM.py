import sys
input = sys.stdin.readline
n = int(input())
pi = list(map(int, input().split()))
pi.sort()

for i in range(1, len(pi)):
    pi[i] = pi[i-1] + pi[i]
print(sum(pi))