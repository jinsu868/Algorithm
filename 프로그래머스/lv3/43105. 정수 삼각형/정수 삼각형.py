def solution(triangle):
    l = len(triangle)
    for i in range(1, l):
        triangle[i][0] = triangle[i-1][0] + triangle[i][0]
        triangle[i][-1] = triangle[i-1][-1] + triangle[i][-1]
        for j in range(1, i):
            triangle[i][j] = max(triangle[i-1][j-1] + triangle[i][j],
                                triangle[i-1][j] + triangle[i][j])
    return max(triangle[l-1])