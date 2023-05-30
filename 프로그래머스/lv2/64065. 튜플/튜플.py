def solution(s):
    s = s[1:-1]
    l = len(s)
    tu = []
    tlist = []
    temp = 0
    flag = False
    check = {}
    
    for i in range(l):
        if s[i] == '{':
            flag = True
            continue
        elif s[i] == '}':
            flag = False
            tlist.append(temp)
            tu.append(tlist)
            tlist = []
            temp = 0
        elif s[i] == ',' and flag == True:
            tlist.append(temp)
            temp = 0
        elif s[i] == ',' and flag == False:
            continue
        else:
            temp *= 10
            temp += int(s[i])
    
    tu.sort(key=len)
    tl = len(tu)
    res = []
    for i in range(tl):
        for x in tu[i]:
            if x in check:
                continue
            res.append(x)
            check[x] = 1
    return res
    
    