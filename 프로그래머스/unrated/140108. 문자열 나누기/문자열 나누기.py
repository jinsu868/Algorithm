def solution(s):
    res, idx = 0, 0
    x = s[0]
    l = len(s)
    a, b = 0, 0
    
    while idx < l:
        if s[idx] == x:
            a += 1
        else:
            b += 1
        
        if a == b:
            res += 1
            a, b = 0, 0
            idx += 1
            if idx < l:
                x = s[idx]
        else:
            idx += 1
    if a == 0 and b == 0:
        return res
    else:
        return res + 1