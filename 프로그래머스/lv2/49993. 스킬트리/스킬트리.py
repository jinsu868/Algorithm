def solution(skill, skill_trees):
    d = {}
    sl = len(skill)
    res = 0
    
    for i in range(sl):
        d[skill[i]] = i
    
    for skill_tree in skill_trees:
        sPtr = 0
        flag = True
        for x in skill_tree:
            if x in d:
                if sPtr == d[x]:
                    sPtr += 1
                else:
                    flag = False
                    break
        if flag == True:
            res += 1
    return res