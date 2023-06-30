word = input()
wordLen = len(word)
res = []

for i in range(1, wordLen-1):
    for j in range(i+1, wordLen):
        a = word[:i]
        b = word[i:j]
        c = word[j:]
        res.append(a[::-1] + b[::-1] + c[::-1])
res.sort()
print(res[0])