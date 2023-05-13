def solution(dartResult):
    res = 0
    star = 0
    state = 'S'
    ch = False
    l = len(dartResult)
    idx = l-1
    while idx >= 0:
        cur = dartResult[idx]
        if cur == '*':
            star += 2
            idx -= 1
        elif cur == '#':
            idx -= 1
            ch = True
        elif cur == 'S':
            idx -= 1
            state = 'S'
        elif cur == 'D':
            idx -= 1
            state = 'D'
        elif cur == 'T':
            idx -= 1
            state = 'T'
        else:
            temp = int(cur)
            if idx != 0 and dartResult[idx-1] == '1':
                temp = 10
                idx -= 1
            
            if state == 'D':
                temp = temp ** 2
            elif state == 'T':
                temp = temp ** 3
            
            if ch == True:
                temp *= -1
                ch = False
            
            # 적용x, 1적용(이번거, 다음꺼까지), 2적용상태
            # 0, 1, 2, 3
            if star == 1 or star == 2:
                temp *= 2
                star -= 1
            elif star == 3:
                temp *= 4
                star -= 2
                
            print("temp : ", temp)
            res += temp
            idx -= 1
    return res
            
            
                
    
