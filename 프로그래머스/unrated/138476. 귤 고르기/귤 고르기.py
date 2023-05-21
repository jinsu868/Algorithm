def solution(k, tangerine):
    res = 0
    d = {}
    
    for x in tangerine:
        if x in d:
            d[x] += 1
        else:
            d[x] = 1
    
    d = sorted(d.items(), key = lambda item : item[1], reverse = True)
    sl = list(d)
    l = len(sl)
    
    for i in range(l):
        if sl[i][1] >= k:
            return res + 1
        else:
            res += 1
            k -= sl[i][1]
        
    
