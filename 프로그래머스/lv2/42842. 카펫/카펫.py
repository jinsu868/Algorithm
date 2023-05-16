def solution(brown, yellow):
    for n in range(3, brown):
        for m in range(3, brown):
            if (2*n+2*m-4) == brown and (n-2)*(m-2) == yellow:
                if n >= m:
                    return [n, m]
                else:
                    return [m, n]
            if 2*n+2*m-4 > brown:
                break
            
    
    
    