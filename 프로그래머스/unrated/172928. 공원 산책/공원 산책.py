def solution(park, routes):
    
    y, x = 0, 0
    
    # find starting point
    lw = len(park[0])
    lh = len(park)
    print("lw, lh : ", lw, lh)
    flag = False
    for i in range(lh):
        for j in range(lw):
            if park[i][j] == 'S':
                y, x = i, j
                flag = True
                break
        if flag == True:
            break
    
    for i in routes:
        d, w = i.split(' ')
        w = int(w)
        flag = False
        if d == 'N':
            if y-w < 0:
                continue
            else:
                for i in range(y-w, y):
                    if park[i][x] == 'X':
                        flag = True
                        continue
                if flag == True:
                    flag = False
                    continue
                y -= w
        elif d == 'E':
            if x+w >= lw:
                continue
            else:
                for i in range(x+1, x+w+1):
                    if park[y][i] == 'X':
                        flag = True
                        continue
                if flag == True:
                    flag = False
                    continue
                x += w
        elif d == 'S':
            if y+w >= lh:
                continue
            else:
                for i in range(y+1, y+w+1):
                    if park[i][x] == 'X':
                        flag = True
                        continue
                if flag == True:
                    flag = False
                    continue
                y += w
        elif d == 'W':
            if x-w < 0:
                continue
            else:
                for i in range(x-w, x):
                    if park[y][i] == 'X':
                        flag = True
                        continue
                if flag == True:
                    flag = False
                    continue
                x -= w
        print("y, x : ", y, x)
    return [y, x]
        