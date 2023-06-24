def trans(num, k):
    d = {10:'A', 11:'B', 12:'C', 13:'D', 14:'E', 15:'F'}
    res = ''
    # k : 바꿀 진법
    # num : 변환 숫자
    
    #num15, k16
    while num >= k:
        temp = num % k
        if temp < 10:
            res += str(temp)
        else:
            res += d[temp]
        num //= k
    
    if num >= 10:
        res += d[num]
    else:
        res += str(num)
    
    return res[::-1]

def solution(n, t, m, p):
    buf = ''
    res = ''
    
    for i in range(0, 100001):
        buf += trans(i, n)
    
    for i in range(t):
        res += buf[i*m+p-1]
    return res