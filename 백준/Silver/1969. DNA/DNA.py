n, m = map(int, input().split())
DNA = []
sumOfhd = 0
res = ''

for _ in range(n):
     DNA.append(input())

#ATGC

for i in range(m):
    d = {'A':0, 'C':0, 'G':0, 'T':0}
    
    for j in range(n):
        d[DNA[j][i]] += 1
    
    maxValue = -1
    key = ''
    for k, v in d.items():
        if maxValue < v:
            key = k
            maxValue = v
            
    for k, v in d.items():
        if key != k:
            sumOfhd += v
    res += key
    
print(res)
print(sumOfhd)