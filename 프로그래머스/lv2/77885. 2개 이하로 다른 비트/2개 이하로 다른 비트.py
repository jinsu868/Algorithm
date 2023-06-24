def solution(numbers):
    res = []
    for num in numbers:
        if num % 2 == 0:
            res.append(num+1)
        else:
            nb = '0' + bin(num)[2:]
            idx = -1
            for i in reversed(range(len(nb))):
                if nb[i] == '0':
                    idx = i
                    break
            nb = nb[:i] + '10' + nb[i+2:]
            res.append(int(nb, 2))
    return res
            