def solution(ingredient):
    '''
    1-2-3-1 -> cnt++
    '''
    s = []
    check = [1, 2, 3, 1]
    res = 0
    count = 0
    
    for x in ingredient:
        s.append(x)
        count += 1
        if count >= 4:
            if s[-4:] == check:
                res += 1
                for _ in range(4):
                    s.pop()
    return res            
    
    
    