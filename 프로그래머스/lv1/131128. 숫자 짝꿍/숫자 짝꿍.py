def solution(X, Y):
    '''
    5525 -> 2555 
    1255 -> 1255
    '''
    res = ''
    for i in reversed(range(10)):
        res += (str(i) * min(X.count(str(i)), Y.count(str(i))))
        
    if res == '':
        return '-1'
    elif len(res) == res.count('0'):
        return '0'
    else:
        return res
    
    
    
    
    
    