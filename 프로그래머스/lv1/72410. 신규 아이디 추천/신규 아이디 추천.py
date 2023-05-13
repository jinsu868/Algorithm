def solution(new_id):
    #1단계
    new_id = new_id.lower()
    print("new_id : ", new_id)
    
    #2단계
    spe = "~!@#$%^&*()=+[{]}:?,<>/"
    for x in spe:
        new_id = new_id.replace(x, '')
    print("new_id : ", new_id)
    
    #3단계
    l = len(new_id)
    temp = ''
    flag = False
    for i in range(l):
        if new_id[i] == '.' and flag == True:
            continue
        if new_id[i] == '.' and flag == False:
            temp += new_id[i]
            flag = True
        if new_id[i] != '.':
            temp += new_id[i]
            flag = False
    new_id = temp
    print("new_id : ", new_id)
    
    #4단계
    new_id = new_id.strip('.')
    print("new_id : ", new_id)
    
    #5단계
    if len(new_id) == 0:
        new_id = 'a'
    print("new_id : ", new_id)
    
    #6단계
    if len(new_id) > 15:
        new_id = new_id[:15]
        if new_id[-1] == '.':
            new_id = new_id.rstrip('.')
    print("new_id : ", new_id)
    
    #7단계
    if len(new_id) <= 2:
        while len(new_id) != 3:
            new_id += new_id[-1]
    print("new_id : ", new_id)
    
    return new_id