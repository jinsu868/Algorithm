def solution(s):
    res = [0, 0] #tCnt, zCnt
    
    while s != '1':
        zCnt = s.count('0')
        res[1] += zCnt
        s = s.replace('0', '')
        l = len(s)
        # zCnt에 값 들어감
        temp = ''
        #11 -> 
        
        while l != 1:
            temp += str(l % 2)
            l //= 2
        temp += '1'
        temp = temp[::-1]
        print("temp : ", temp)
        s = temp
        
        res[0] += 1
    return res