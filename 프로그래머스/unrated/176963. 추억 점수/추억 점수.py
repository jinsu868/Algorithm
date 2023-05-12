def solution(name, yearning, photo):
    d = dict()
    result = []
    for i in range(len(name)):
        d[name[i]] = yearning[i]
    
    for i in range(len(photo)):
        p = photo[i]
        score = 0
        for x in p:
            if x in d:
                score += d[x]
        result.append(score)
    return result