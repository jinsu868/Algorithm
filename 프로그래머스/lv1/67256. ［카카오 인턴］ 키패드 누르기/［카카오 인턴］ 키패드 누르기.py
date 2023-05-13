def solution(numbers, hand):
    '''
    1, 4, 7 -> L
    3, 6, 9 -> R
    2, 5, 8, 0 -> nearest (같은 경우 hand에 따라)
    
    '''
    d = {1:(0,0), 2:(1,0), 3:(2, 0), 4:(0, 1), 5:(1,1), 6:(2,1),
              7:(0,2), 8:(1,2), 9:(2,2), 10:(0,3), 0:(1,3), 11:(2,3)}

    lPos = 10
    rPos = 11
    result = ''
    for n in numbers:
        if n == 1:
            result += 'L'
            lPos = 1
        elif n == 4:
            result += 'L'
            lPos = 4
        elif n == 7:
            result += 'L'
            lPos = 7
        elif n == 3:
            result += 'R'
            rPos = 3
        elif n == 6:
            result += 'R'
            rPos = 6
        elif n == 9:
            result += 'R'
            rPos = 9
        else:
            nextPos = d[n]
            left = d[lPos]
            right = d[rPos]
            distLeft = abs(nextPos[0] - left[0]) + abs(nextPos[1] - left[1])
            distRight = abs(nextPos[0] - right[0]) + abs(nextPos[1] - right[1])
            
            if distLeft > distRight:
                result += 'R'
                rPos = n
            elif distLeft < distRight:
                result += 'L'
                lPos = n
            else:
                if hand == "right":
                    result += 'R'
                    rPos = n
                else:
                    result += 'L'
                    lPos = n
    return result
            