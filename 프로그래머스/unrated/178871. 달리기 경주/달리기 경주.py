def solution(players, callings):
    d1 = {} # 선 - 등
    d2 = {} # 등 - 선
    l = len(players)
    
    for i in range(l):
        d1[players[i]] = i+1
        d2[i+1] = players[i]
    
    for call in callings:
        rank = d1[call]
        change = d2[rank-1] #앞서 달리던 선수 이름
        d1[change] = rank
        d1[call] = rank-1
        d2[rank] = change
        d2[rank-1] = call
    
    res = []
    for i in range(1, l+1):
        res.append(d2[i])
        
    return res
        
        