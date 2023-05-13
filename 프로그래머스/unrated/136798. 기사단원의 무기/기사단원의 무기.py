import math
def solution(number, limit, power):
    '''
    number : 기사 수
    limit : 협의 공격력 : 초과 시 power 에 해당하는 무기 할당
    
    return -> 모든 기사 power의 합
    '''
    
    res = 0
    w = []
    
    for x in range(1, number+1):
        temp = 0
        for i in range(1, int(math.sqrt(x))+1):
            if i * i == x:
                temp += 1
            elif x % i == 0:
                temp += 2
        if temp > limit:
            w.append(power)
        else:
            w.append(temp)
    res = sum(w)
    return res
    