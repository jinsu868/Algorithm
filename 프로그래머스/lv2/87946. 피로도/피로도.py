def solution(k, dungeons):
    l = len(dungeons)
    res = set()
    def dfs(v, visit, p, n):
        flag = False
        for i in range(l):
            if visit[i] == False and dungeons[i][0] <= p:
                flag = True
        if flag == False:
            res.add(n)
        else:
            for i in range(l):
                if visit[i] == False and dungeons[i][0] <= p:
                    visit[i] = True
                    dfs(i, visit, p-dungeons[i][1], n+1)
                    visit[i] = False
                    
    for i in range(l):
        if dungeons[i][0] <= k:
            visit = [False] * l
            visit[i] = True
            dfs(i, visit, k-dungeons[i][1], 1)
    
    return max(res)
    
    answer = -1
    return answer