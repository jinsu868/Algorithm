def solution(n):
    d = [0] * 100001
    d[0] = 0
    d[1] = 1
    for i in range(2, 100001):
        d[i] = d[i-1] + d[i-2]
    return d[n] % 1234567
    