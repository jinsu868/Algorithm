def solution(n, words):
    
    if len(words[0]) == 1:
        return [1, 1]
    
    l = len(words)
    check = {}
    
    before = words[0][-1]
    check[words[0]] = 1
    t = 0
    flag = True
    
    for i in range(1, l):
        if len(words[i]) == 1:
            t = i
            break
        
        cur = words[i][0]

        if cur == before:
            if words[i] in check:
                # fail
                flag = False
                t = i
                break
            else:
                check[words[i]] = 1
                before = words[i][-1]
        else:
            # fail
            flag = False
            t = i
            break
    
    if flag == True:
        return [0, 0]
    else:
        return [t%n+1, t//n+1]
        