def solution(land):
    l = len(land)
    for i in range(1, l):
        land[i][0] = max(land[i-1][1], land[i-1][2], land[i-1][3]) + land[i][0]
        land[i][1] = max(land[i-1][0], land[i-1][2], land[i-1][3]) + land[i][1]
        land[i][2] = max(land[i-1][0], land[i-1][1], land[i-1][3]) + land[i][2]
        land[i][3] = max(land[i-1][0], land[i-1][1], land[i-1][2]) + land[i][3]
    return max(land[l-1])