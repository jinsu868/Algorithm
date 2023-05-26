def solution(routes):
    routes.sort(key = lambda x : x[1])
    res = 0
    idx = 0
    l = len(routes)
    
    while idx < l:
        cur = routes[idx][1]
        res += 1
        while idx < l and cur >= routes[idx][0]:
            idx += 1
        
    return res