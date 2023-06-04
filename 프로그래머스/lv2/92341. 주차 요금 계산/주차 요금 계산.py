def solution(fees, records):
    buf = {}
    d = {}
    l = len(records)
    dm = 60 * 23 + 59
    res = []
    
    for i in range(l):
        time, num, flag = records[i].split(' ')
        h, m = time.split(':')
        time = int(h) * 60 + int(m)
        
        if flag == 'IN':
            buf[num] = time
        elif flag == 'OUT':
            if num not in d:
                d[num] = time - buf[num]
            else:
                d[num] += time - buf[num]
            del buf[num]
            
    for x in buf.keys():
        if x not in d:
            d[x] = dm - buf[x]
        else:
            d[x] += dm - buf[x]
    
    d = sorted(d.items())
    
    for x in d:
        t = x[1]
        temp = 0
        if t <= fees[0]:
            temp += fees[1]
        else:
            temp += fees[1]
            t -= fees[0]
            if t % fees[2] == 0:
                temp += fees[3] * (t // fees[2])
            else:
                temp += fees[3] * (t // fees[2] + 1)
        res.append(temp)
    return res
            
    
    
        