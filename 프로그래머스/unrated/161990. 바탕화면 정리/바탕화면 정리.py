def solution(wallpaper):
    n = len(wallpaper)
    m = len(wallpaper[0])
    
    colList = []
    rowList = []
    
    for i in range(n):
        for j in range(m):
            if wallpaper[i][j] == "#":
                colList.append([i, j])
                rowList.append([i, j])
                
    colList.sort(key = lambda x : x[1])
    rowList.sort(key = lambda x : x[0])

    res = [rowList[0][0], colList[0][1], rowList[-1][0]+1, colList[-1][1]+1]
    return res