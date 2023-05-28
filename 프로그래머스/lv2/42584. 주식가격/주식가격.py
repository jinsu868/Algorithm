def solution(prices):
    res = []
    l = len(prices)
    for i in range(l):
        x = prices[i]
        temp = 0
        for j in range(i+1, l):
            temp += 1
            if x > prices[j]:
                break
        res.append(temp)
    return res
        
    