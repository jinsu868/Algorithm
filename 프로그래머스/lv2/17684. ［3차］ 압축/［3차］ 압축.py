def solution(msg):
    l = len(msg)
    d = {}
    res = []
    cnt = 1
    
    for i in range(ord('A'), ord('Z')+1):
        d[chr(i)] = cnt
        cnt += 1
    
    cur = 0
    while cur < l:
        idx = cur+1
        while idx <= l:
            if msg[cur:idx] in d:
                idx += 1
            else:
                break
        
        if not msg[cur:idx] in d:
            d[msg[cur:idx]] = cnt
        cnt += 1    
        
        res.append(d[msg[cur:idx-1]])
        cur = idx-1
    print(d)
    return res
        
        
    
    