def solution(n, left, right):
    res = []
    for i in range(left, right+1):
        res.append(max(i%n, i//n)+1)
    return res
