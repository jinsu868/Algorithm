def solution(participant, completion):
    d = dict()
    
    for x in participant:
        if x in d:
            d[x] += 1
        else:
            d[x] = 1

    
    for x in completion:
        d[x] -= 1
        if d[x] == 0:
            del d[x]
    
    return list(d)[0]        