def solution(t, p):
    res = 0
    tLen = len(t)
    pLen = len(p)
    n = int(p)
    
    for i in range(tLen-pLen+1):
        temp = int(t[i:i+pLen])
        if temp <= n:
            res += 1
    return res