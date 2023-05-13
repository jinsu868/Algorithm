def solution(board, moves):
    bucket = []
    l = len(board)
    res = 0
    
    for x in moves: # column이 정해짐
        x -= 1
        cur = 0
        for y in range(l):
            if board[y][x] == 0:
                continue
            else:
                cur = board[y][x]
                board[y][x] = 0
                break
        if cur == 0: # 빈 칸을 집은 경우
            continue
        if len(bucket) == 0:
            bucket.append(cur)
        elif bucket[-1] == cur:
            bucket.pop()
            res += 2
        else:
            bucket.append(cur)
    return res