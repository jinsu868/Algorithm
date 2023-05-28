def solution(numbers, target):
    res = []
    l = len(numbers)
    
    def dfs(v, k):
        if v == l-1:
            if target == k:
                res.append(0)
        else:
            dfs(v+1, k-numbers[v+1])
            dfs(v+1, k+numbers[v+1])
    
    dfs(0, numbers[0])
    dfs(0, -numbers[0])
    
    return len(res)