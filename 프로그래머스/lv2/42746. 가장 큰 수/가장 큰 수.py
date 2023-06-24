def solution(numbers): 
    
    for i in range(len(numbers)):
        numbers[i] = str(numbers[i])
    
    numbers.sort(reverse = True, key = lambda x : x*3)
    
    return str(int(''.join(numbers)))