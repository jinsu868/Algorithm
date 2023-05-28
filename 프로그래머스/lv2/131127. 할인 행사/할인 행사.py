import copy
def solution(want, number, discount):
    d = {}
    l = len(want)
    ld = len(discount)
    s = sum(number)
    res = 0
    
    for i in range(l):
        d[want[i]] = number[i]
    

    for i in range(ld-s+1):
        td = copy.deepcopy(d)
        for j in range(i, i+s):
            if discount[j] in td:
                td[discount[j]] -= 1
                if td[discount[j]] == 0:
                    del td[discount[j]]
        if not td:
            res += 1
    return res