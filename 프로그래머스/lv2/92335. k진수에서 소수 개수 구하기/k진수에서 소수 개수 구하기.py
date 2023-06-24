import math

def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

def solution(n, k):    
    res = 0
    tn = ''
    
    if k == 10:
        tn += str(n)
    else:
        while n > k:
            tn += str(n % k)
            n //= k
        tn += str(n)
        tn = tn[::-1]
    
    while '00' in tn:
        tn = tn.replace('00', '0')
    tl = tn.split('0')
    
    for x in tl:
        if x == '':
            continue
        x = int(x)
        if isPrime(x):
            res += 1
    return res
            
    
    