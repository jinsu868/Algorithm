def solution(s):
    
    l = len(s)
    res = ''
    flag = True
    for i in range(l):
        if s[i].isdecimal():
            res += s[i]
            flag = False
        else:
            if s[i] == ' ':
                res += ' '
                flag = True
            else:
                if flag == True:
                    res += s[i].upper()
                    flag = False
                else:
                    res += s[i].lower()
    return res
        
            
    
    return res
    