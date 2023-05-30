import math
def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()

    s1 = []
    s2 = []
    
    l1 = len(str1)
    l2 = len(str2)
    
    d1 = {}
    d2 = {}
    
    s = 0
    c = 0
    
    for i in range(l1-1):
        if str1[i:i+2].isalpha():
            if str1[i:i+2] in d1:
                d1[str1[i:i+2]] += 1
            else:
                d1[str1[i:i+2]] = 1
            
    for i in range(l2-1):
        if str2[i:i+2].isalpha():
            if str2[i:i+2] in d2:
                d2[str2[i:i+2]] += 1
            else:
                d2[str2[i:i+2]] = 1
    
    for key in d1.keys():
        if key in d2:
            if d1[key] > d2[key]:
                s += d1[key]
                c += d2[key]
            else:
                c += d1[key]
                s += d2[key]
        else:
            s += d1[key]
            
    for key in d2.keys():
        if key in d1:
            continue
        else:
            s += d2[key]
    
    if c == 0 and s == 0:
        return 65536
    else:
        return int(math.floor(c / s * 65536))
        
            
    

    
    
    
    
    
    
        
        
    
        