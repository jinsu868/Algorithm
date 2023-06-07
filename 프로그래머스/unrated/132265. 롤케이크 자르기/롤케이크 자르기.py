def solution(topping):
    d1 = {}
    d2 = {}
    res = 0
    
    for x in topping:
        if x in d1:
            d1[x] += 1
        else:
            d1[x] = 1
        
    for x in topping:
        if x in d2:
            d2[x] += 1
        else:
            d2[x] = 1
        d1[x] -= 1
        
        if d1[x] == 0:
            del d1[x]
        
        if len(d1) == len(d2):
            res += 1
        elif len(d1) < len(d2):
            break
            
    return res
    