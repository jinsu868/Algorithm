n = int(input())
word = []    
res = []

for _ in range(n):
    word.append(input())

word = list(set(word))
word.sort(key=lambda x : len(x), reverse = True)

for i in range(len(word)):
    l = len(res)
    flag = False
    for j in range(l):
        if res[j].find(word[i]) == 0:
            flag = True
            break
    if flag == True:
        continue
    else:
        res.append(word[i])
        
print(len(res))