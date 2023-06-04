def solution(record):
    d = {}
    l = len(record)
    re = []
    res = []
    for i in range(l):
        r = record[i].split(' ')
        if len(r) == 2:
            re.append([r[0], r[1]]) 
        else:
            if r[0] == 'Enter':
                d[r[1]] = r[2]
                re.append([r[0], r[1]])
            else:
                d[r[1]] = r[2]
                
    for x in re:
        if x[0] == 'Enter':
            temp = d[x[1]] + '님이 들어왔습니다.'
            res.append(temp)
        else:
            temp = d[x[1]] + '님이 나갔습니다.'
            res.append(temp)
    return res
                
        
        