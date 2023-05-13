def solution(babbling):
    res = 0
    
    for x in babbling:
        cur = 0
        before = ''
        l = len(x)
        flag = True
        while cur < l:
            if x[cur] == 'a':
                if x.find('aya', cur) == cur:
                    if before == 'aya':
                        flag = False
                        break
                    else:
                        before = 'aya'
                        cur += 3
                else:
                    flag = False
                    break
            elif x[cur] == 'y':
                if x.find('ye', cur) == cur:
                    if before == 'ye':
                        flag = False
                        break
                    else:
                        before = 'ye'
                        cur += 2
                else:
                    flag = False
                    break
            elif x[cur] == 'w':
                if x.find('woo', cur) == cur:
                    if before == 'woo':
                        flag = False
                        break
                    else:
                        before = 'woo'
                        cur += 3
                else:
                    flag = False
                    break
            elif x[cur] == 'm':
                if x.find('ma', cur) == cur:
                    if before == 'ma':
                        flag = False
                        break
                    else:
                        before = 'ma'
                        cur += 2
                else:
                    flag = False
                    break
            else:
                break
        if cur != l:
            flag = False
        if flag == True:
            print("성공 케이스 x : ", x)
            res += 1
    return res
        