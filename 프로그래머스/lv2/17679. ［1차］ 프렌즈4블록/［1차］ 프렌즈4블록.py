def solution(m, n, board):
    # m : 높이, n : 폭
    res = 0
    for i in range(m):
        board[i] = list(board[i])
    
    
    
    while True:
        rmv = set()
        
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1] and board[i][j] != 'X':
                    rmv.add((i,j))
                    rmv.add((i+1,j))
                    rmv.add((i,j+1))
                    rmv.add((i+1,j+1))
        
        if not rmv:
            return res
        else:
            res += len(rmv)
            for i, j in rmv:
                board[i][j] = 'X'
        
        
        
        while True:
            mv = False
            for i in range(m-1):
                for j in range(n):
                    if board[i+1][j] == 'X' and board[i][j] != 'X':
                        board[i+1][j] = board[i][j]
                        board[i][j] = 'X'
                        mv = True
            if mv == False:
                break
    
    return res

        
    
    
    
        