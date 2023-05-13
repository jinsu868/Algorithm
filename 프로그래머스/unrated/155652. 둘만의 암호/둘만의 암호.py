def solution(s, skip, index):
    #26
    alph = 'abcdefghijklmnopqrstuvwxyz'
    result = ''
    
    for x in s:
        cur = x
        count = 0
        curPos = alph.find(x)
        while count < index:
            curPos = (curPos+1)%26
            if alph[curPos] in skip:
                continue
            count += 1
        result += alph[curPos]
    return result
                
        
            