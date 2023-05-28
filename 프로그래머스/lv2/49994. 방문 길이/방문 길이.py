def solution(dirs):
    y, x = 0, 0
    d = {'D':(0,-1), 'U':(0,1), 'L':(-1,0), 'R':(1,0)}
    s = set()
    
    for dir in dirs:
        nx, ny = x+d[dir][0], y+d[dir][1]
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            print("nx, ny :", nx, ny)
            s.add((x, y, nx, ny))
            s.add((nx, ny, x, y))    
            x, y = nx, ny
    return len(s) // 2
    
    