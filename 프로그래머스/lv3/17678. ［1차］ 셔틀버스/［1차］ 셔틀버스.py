from collections import deque
def solution(n, t, m, timetable):
    busTime = deque()
    time = []
    
    for x in timetable:
        h, mi = map(int, x.split(':'))
        time.append(h*60 + mi)
    
    time.sort(reverse = True)
    
    for i in range(n):
        busTime.append(540 + i*t)
    
    while busTime:
        if len(busTime) == 1:
            tl = len(time)
            if tl < m:
                res = busTime[0]
            else:
                res = time[-m] -1
                if busTime[0] < res:
                    res = busTime[0]
        else:
            for i in range(m):
                try:
                    if time[-1] <= busTime[0]:
                        time.pop()
                except:
                    break
        busTime.popleft()
        
    hour = str(res//60)
    if len(hour) == 1:
        hour = '0' + hour
    mi = str(res%60)
    if len(mi) == 1:
        mi = '0' + mi
    
    
    return hour + ':' + mi
                
            
        
        
           