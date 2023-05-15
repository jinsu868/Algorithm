def isPossible(s, n):
    temp = 0
    for i in range(s, n+1):
        temp += i
        if temp == n:
            return True
        elif temp > n:
            return False
    

def solution(n):
    res = 0
    for s in range(1, n+1):
        if isPossible(s, n):
            res += 1
    return res
