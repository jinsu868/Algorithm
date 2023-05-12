def isPrime(x):
    for i in range(2, x//2+1):
        if x % i == 0:
            return False
    return True

def solution(nums):
    res = 0
    l = len(nums)
    
    for a in range(0, l):
        for b in range(a+1, l):
            for c in range(b+1, l):
                temp = nums[a] + nums[b] + nums[c]
                if isPrime(temp):
                    res += 1
    return res


    