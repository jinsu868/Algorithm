from collections import deque
def solution(n, lost, reserve):
    '''
    n : 학생 수
    lost : 잃어버린 학생 번호
    reserver : 여벌 체육복 가져온 친구들 번호
    +-1 에게 빌려줄 수 있음.
    return : 체육 수업 들을 수 있는 최대 학생 수 
    '''
    
    temp = []
    q = deque()
    
    # 여벌 있는데 잃어버린 애들 다 제거
    for i in reserve:
        if i in lost:
            lost.remove(i)
            temp.append(i)
    for i in temp:
        reserve.remove(i)
    
    #양 사이드 중 한명 만 여벌을 가지고 있는 애들 q에 집어넣음.
    for i in lost:
        if i+1 in reserve and i-1 not in reserve:
            q.append(i)
        elif i+1 not in reserve and i-1 in reserve:
            q.append(i)
    
    #한 사이드만 여벌 가지고 있는 애들 먼저 처리
    while q:
        cur = q.popleft()
        if cur+1 in reserve:
            lost.remove(cur)
            reserve.remove(cur+1)
        elif cur-1 in reserve:
            lost.remove(cur)
            reserve.remove(cur-1)
    
    
    temp = []
    for i in lost:
        if i+1 in reserve:
            reserve.remove(i+1)
            temp.append(i)
        elif i-1 in reserve:
            reserve.remove(i-1)
            temp.append(i)
        
    for x in temp:
        lost.remove(x)
    
    return n - len(lost)

    