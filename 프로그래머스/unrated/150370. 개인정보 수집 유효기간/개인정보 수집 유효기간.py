def solution(today, terms, privacies):
    d = {}
    result = []
    
    ty, tm, td = map(int, today.split('.'))
    
    for i in range(len(terms)):
        term = terms[i].split(' ')
        d[term[0]] = int(term[1])
    
    for i in range(len(privacies)):
        day, term = privacies[i].split(' ')
        y, m, da = map(int, day.split('.'))
        
        num = d[term]
        m += num
        # 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 1~12 y+0
        # 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0
        # 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 13~24 y+1
        # 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2
        # 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0
        # 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 25~36 y+2
        # 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3
        if m % 12 == 0:
            y += (m//12 -1)
            m = 12
        else:
            y += m//12
            m %= 12
            
        if ty > y:
            result.append(i+1)
            continue
        elif ty == y:
            if tm > m:
                result.append(i+1)
                continue
            elif tm == m:
                if td >= da:
                    result.append(i+1)
                    continue
    return result

