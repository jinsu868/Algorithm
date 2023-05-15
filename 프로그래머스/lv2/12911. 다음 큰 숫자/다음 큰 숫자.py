def solution(n):
    tn = ''
    
    idx = n+1
    while n != 1:
        tn += str(n % 2)
        n //= 2
    tn += '1'
    
    while True:
        if idx == 84:
            break
        temp = idx
        tn2 = ''
        while temp != 1:
            tn2 += str(temp % 2)
            temp //= 2
        tn2 += '1'
        
        if tn.count('1') == tn2.count('1'):
            break
        idx += 1
        

        
    return idx
            
        
    
    
    