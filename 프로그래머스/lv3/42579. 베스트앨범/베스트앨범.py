def solution(genres, plays):
    l = len(genres)
    d = {}
    res = []
    
    for i in range(l):
        if genres[i] in d:
            d[genres[i]].append([plays[i], i])
            d[genres[i]][0] += plays[i]
        else:
            d[genres[i]] = [plays[i], [plays[i], i]]
    
    r = sorted(d, reverse = True, key = lambda x : d[x][0])
    print(d)
    
    for gen in r:
        
        value = d[gen][1:]
        print(value)
        value.sort(reverse = True, key = lambda x : x[0])
          
        lv = len(value)
        for i in range(lv):
            if i == 2:
                break
            res.append(value[i][1])
    return res
    