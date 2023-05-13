def solution(keymap, targets):
    '''
    timecomplexity = 
    target수 * target길이 * keymap수 * keymap길이
    100**4 = 10**8 = 100000000 -> possible
    '''
    INF = int(1e9)
    res = []
    for target in targets:
        temp = 0
        for x in target:
            cnt = INF
            flag = False
            for key in keymap:
                idx = key.find(x)
                if idx == -1:
                    continue
                cnt = min(cnt, idx+1)
                flag = True
            
            if flag == False:
                temp = -1
                break
            else:
                temp += cnt
        res.append(temp)
    return res