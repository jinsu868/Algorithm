def solution(survey, choices):
    '''
        비동의           동의
    survey[i][0], survey[i][1]
    '''
    
    l = len(survey)
    rt = [0, 0]
    cf = [0, 0]
    jm = [0, 0]
    an = [0, 0]
    
    for i in range(l):
        s = survey[i]
        c = choices[i]
        if s[0] == 'R': #RT
            if c == 1:
                rt[0] += 3
            elif c == 2:
                rt[0] += 2
            elif c == 3:
                rt[0] += 1
            elif c == 5:
                rt[1] += 1
            elif c == 6:
                rt[1] += 2
            elif c == 7:
                rt[1] += 3
        elif s[0] == 'T':
            if c == 1:
                rt[1] += 3
            elif c == 2:
                rt[1] += 2
            elif c == 3:
                rt[1] += 1
            elif c == 5:
                rt[0] += 1
            elif c == 6:
                rt[0] += 2
            elif c == 7:
                rt[0] += 3
        elif s[0] == 'C':
            if c == 1:
                cf[0] += 3
            elif c == 2:
                cf[0] += 2
            elif c == 3:
                cf[0] += 1
            elif c == 5:
                cf[1] += 1
            elif c == 6:
                cf[1] += 2
            elif c == 7:
                cf[1] += 3
        elif s[0] == 'F':
            if c == 1:
                cf[1] += 3
            elif c == 2:
                cf[1] += 2
            elif c == 3:
                cf[1] += 1
            elif c == 5:
                cf[0] += 1
            elif c == 6:
                cf[0] += 2
            elif c == 7:
                cf[0] += 3
        elif s[0] == 'J':
            if c == 1:
                jm[0] += 3
            elif c == 2:
                jm[0] += 2
            elif c == 3:
                jm[0] += 1
            elif c == 5:
                jm[1] += 1
            elif c == 6:
                jm[1] += 2
            elif c == 7:
                jm[1] += 3
        elif s[0] == 'M':
            if c == 1:
                jm[1] += 3
            elif c == 2:
                jm[1] += 2
            elif c == 3:
                jm[1] += 1
            elif c == 5:
                jm[0] += 1
            elif c == 6:
                jm[0] += 2
            elif c == 7:
                jm[0] += 3
        elif s[0] == 'A':
            if c == 1:
                an[0] += 3
            elif c == 2:
                an[0] += 2
            elif c == 3:
                an[0] += 1
            elif c == 5:
                an[1] += 1
            elif c == 6:
                an[1] += 2
            elif c == 7:
                an[1] += 3
        elif s[0] == 'N':
            if c == 1:
                an[1] += 3
            elif c == 2:
                an[1] += 2
            elif c == 3:
                an[1] += 1
            elif c == 5:
                an[0] += 1
            elif c == 6:
                an[0] += 2
            elif c == 7:
                an[0] += 3
    
    #rt, cf, jm, an
    res = ''
    if rt[0] >= rt[1]:
        res += 'R'
    else:
        res += 'T'
    
    if cf[0] >= cf[1]:
        res += 'C'
    else:
        res += 'F'
    
    if jm[0] >= jm[1]:
        res += 'J'
    else:
        res += 'M'
    
    if an[0] >= an[1]:
        res += 'A'
    else:
        res += 'N'
        
    return res
    