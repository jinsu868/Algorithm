def solution(clothes):
    d = {}
    res = 1
    
    for i in range(len(clothes)):
        if clothes[i][1] in d:
            d[clothes[i][1]] += 1
        else:
            d[clothes[i][1]] = 1
    l = list(d.values())
    
    for x in l:
        res *= (x+1)
    return res - 1
    