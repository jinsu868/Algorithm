def solution(n):
    oCnt = bin(n)[2:].count('1')
    
    n += 1
    while True:
        tCnt = bin(n)[2:].count('1')
        if tCnt == oCnt:
            return n
        else:
            n += 1
    
    
    
    
        