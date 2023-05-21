def gcd(a, b):
    if a < b:
        a, b = b, a
    while b != 0:
        n = a % b
        a = b
        b = n
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

def solution(arr):
    res = arr[0]
    l = len(arr)
    
    for i in range(1, l):
        res = lcm(res, arr[i])
    return res
        
    