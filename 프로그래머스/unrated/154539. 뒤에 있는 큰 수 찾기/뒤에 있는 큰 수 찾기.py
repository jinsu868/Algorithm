def solution(numbers):
    s = []
    t = -1
    l = len(numbers)
    res = []
    
    for i in reversed(range(l)):
        cur = numbers[i]
        if t == -1:
            res.append(-1)
            s.append(cur)
            t += 1
        elif s[t] > cur:
            res.append(s[t])
            s.append(cur)
            t += 1
        else:
            while s:
                if s[t] > cur:
                    res.append(s[t])
                    s.append(cur)
                    t += 1
                    break
                else:
                    t -= 1
                    s.pop()
            if not s:
                res.append(-1)
                s.append(cur)
                t += 1
        
    return list(reversed(res))
    