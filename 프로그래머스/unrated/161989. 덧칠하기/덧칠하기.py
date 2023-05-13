def solution(n, m, section):
    '''
    안칠한 section 중 가장 작은 칸을 기준으로 m칸 칠하고 
    또 안칠해진 section 중 가장 작은 값을 찾아서 roop를 돈다.
    
    종결조건 : 칠했을 때, 마지막 section 값보다 크거나 같으며 end
    '''
    
    res = 0
    cur = 0
    l = len(section)
    
    while True:
        if section[cur] + m - 1 >= section[-1]:
            res += 1
            break
        res += 1
        for i in range(cur , l):
            if section[i] > section[cur] + m - 1:
                cur = i
                break
    return res
    
    
    
    
    