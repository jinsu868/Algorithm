def solution(id_list, report, k):
    l = len(id_list)
    
    #중복 신고 체크
    check = {}
    
    # 신고 당한 횟수 체크
    d = {}
    
    resTemp = {}
    
    res = []
    
    for i in range(len(report)):
        a, b = report[i].split(' ')
        if a in check:
            if b in check[a]:
                continue
            else:
                check[a].append(b)
                if b in d:
                    d[b] += 1
                else:
                    d[b] = 1
        else: # a가 신고를 처음 한 케이스
            check[a] = [b]
            if b in d:
                d[b] += 1
            else:
                d[b] = 1

    
    for x in d:
        if d[x] >= k: # 신고 횟수 초과된 경우
            for i in id_list:
                if i in check:
                    if x in check[i]:
                        if i in resTemp:
                            resTemp[i] += 1
                        else:
                            resTemp[i] = 1
    
    for i in id_list:
        if i in resTemp:
            res.append(resTemp[i])
        else:
            res.append(0)
    return res
            
                
            