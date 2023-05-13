def solution(cards1, cards2, goal):
    res = "Yes"
    c1Ptr, c2Ptr = 0, 0
    gPtr = 0
    lenc1 = len(cards1)
    lenc2 = len(cards2)
    leng = len(goal)
    
    while c1Ptr < lenc1 and c2Ptr < lenc2 and gPtr < leng:
        if cards1[c1Ptr] == goal[gPtr]:
            c1Ptr += 1
            gPtr += 1
        elif cards2[c2Ptr] == goal[gPtr]:
            c2Ptr += 1
            gPtr += 1
        else:
            res = "No"
            break
    
    
    if c1Ptr == lenc1 and gPtr < leng:
        while gPtr < leng:
            if cards2[c2Ptr] != goal[gPtr]:
                res = "No"
                break
            c2Ptr += 1
            gPtr += 1
            
    if c2Ptr == lenc2 and gPtr < leng:
        while gPtr < leng:
            if cards1[c1Ptr] != goal[gPtr]:
                res = "No"
                break
            c1Ptr += 1
            gPtr += 1
            
    
    if gPtr != leng:
        res = "No"
    
    
    return res