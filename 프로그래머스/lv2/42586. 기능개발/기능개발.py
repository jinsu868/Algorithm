def solution(progresses, speeds):
    complete = []
    l = len(progresses)
    res = []
    
    for i in range(l):
        temp = 100 - progresses[i]
        if temp % speeds[i] == 0:
            complete.append(temp // speeds[i])
        else:
            complete.append(temp // speeds[i] + 1)
    
    last = complete[0]
    cnt = 1
    for i in range(1, l):
        if last >= complete[i]:
            cnt += 1
        else:
            last = complete[i]
            res.append(cnt)
            cnt = 1
    res.append(cnt)
    
    return res