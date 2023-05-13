def solution(k, m, score):
    res = 0
    l = len(score)
    score.sort()
    if m <= l:
        idx = l-1
        while idx-m+1 >= 0:
            res += score[idx-m+1] * m
            idx -= m
    return res
