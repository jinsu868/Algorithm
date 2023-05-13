def solution(lottos, win_nums):
    '''
    최고 순위 -> 0을 모두 맞은 것으로 가정하면 된다.
    최저 순위 -> 0을 모두 틀린 것으로 가정하면 된다.

    lottos -> 민우 번호
    win_nums -> 당첨 번호
    순서 무관
    '''
    rank = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    res = []
    count = 0
    zCnt = 0

    for x in lottos:
        if x == 0:
            zCnt += 1
        if x in win_nums:
            count += 1
    
    a = count + zCnt
    b = count
    
    res.append(rank[a])
    res.append(rank[b])
        
    return res
    
        
    