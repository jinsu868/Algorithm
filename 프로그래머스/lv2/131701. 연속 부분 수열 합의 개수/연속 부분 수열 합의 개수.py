def solution(elements):
    s = set()
    l = len(elements)
    
    for i in range(l): # i : starting point
        for j in range(1, l+1): # j : 수열의 길이
            if i+j == l:
                s.add(sum(elements[i:]))
            elif i + j < l:
                s.add(sum(elements[i:i+j]))
            else:
                s.add(sum(elements[i:]) + sum(elements[:(i+j)%l-1]))
    return len(s)
                
                
        