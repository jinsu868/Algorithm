def solution(people, limit):
    res = 0
    s = 0
    people.sort()
    e = len(people) - 1
    
    while s <= e:
        res += 1
        if people[s] + people[e] <= limit:
            s += 1
        e -= 1
        
    return res