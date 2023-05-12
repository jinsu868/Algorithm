def solution(a, b, n):
    #빈병a -> b병 줄 때, n개 주면 몇 병 받냐?
    res = 0 
    
    while n >= a:
        temp =  (n // a) * b
        n %= a
        n += temp
        res += temp
        
    return res
        
    
    