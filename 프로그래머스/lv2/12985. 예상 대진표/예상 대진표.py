def solution(n,a,b):
    res = 0
    
    while True:
        if a == b:
            break
        
        if a % 2 == 0:
            a //= 2
        else:
            a //= 2
            a += 1            
        if b % 2 == 0:
            b //= 2
        else:
            b //= 2
            b += 1
            
        res += 1
        
    return res