from collections import deque
import copy
def solution(priorities, location):
    x = copy.deepcopy(priorities)
    top = 0
    x.sort(reverse = True)
    pi = deque()
    res = 0
    
    for i in range(len(priorities)):
        pi.append([i, priorities[i]])
    
    while pi:
        temp = pi.popleft()
        if temp[1] == x[top]:
            res += 1
            if temp[0] == location:
                return res
            top += 1
        else:
            pi.append(temp)
    
                    
                
                
            
        