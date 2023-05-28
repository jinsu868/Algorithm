def solution(phone_book):
    d = {}
    phone_book.sort(key=len)
    
    for x in phone_book:
        l = len(x)
        for i in range(1,l):
            temp = x[:i]
            if temp in d:
                return False
        d[x] = 1
    return True