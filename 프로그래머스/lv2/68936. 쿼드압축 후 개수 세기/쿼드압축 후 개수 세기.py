import sys
sys.setrecursionlimit(10**8)
def solution(arr):
    res = [0, 0] #0, 1 cnt
    n = len(arr)
    
    def quadComp(x1, y1, x2, y2):
        value = arr[y1][x1]
        if x1 == x2:
            res[value] += 1
            return
        isSame = True
        flag = False
        for i in range(y1, y2+1):
            for j in range(x1, x2+1):
                if arr[i][j] != value:
                    flag = True
                    isSame = False
                    break
            if flag == True:
                break
                
        if isSame:
            res[value] += 1
            return
        else:
            xMid = (x1 + x2) // 2
            yMid = (y1 + y2) // 2
            quadComp(x1, y1, xMid, yMid)
            quadComp(xMid+1, y1, x2, yMid)
            quadComp(x1, yMid+1, xMid, y2)
            quadComp(xMid+1, yMid+1, x2, y2)
    quadComp(0,0,n-1,n-1)
    return res