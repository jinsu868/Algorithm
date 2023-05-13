def solution(N, stages):
    # N -> 전체 스테이지 개수, statges : 현재 멈춰있는 스테이지 번호
    # 실패율 : 현재 멈춰 있는 스테이지 번호가 현 스테이지 / 이 이상
    res = []
    stages.sort()
    l = len(stages)
    for i in range(1, N+1):
        x = -1
        for k in range(l):
            if stages[k] == i:
                x = k
                break
        print("x : ", x)
        if x == -1:
            res.append([0, i]) # 실패율, stageNum
        else:
            temp = 0
            for j in range(x, l):
                if stages[j] == i:
                    temp += 1
                else:
                    break
            res.append([temp / (l-x), i])
    res.sort(reverse = True, key = lambda x : x[0])
    ans = []
    for x in res:
        ans.append(x[1])
    return ans