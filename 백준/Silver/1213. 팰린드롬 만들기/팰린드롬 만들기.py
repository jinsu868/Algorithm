word = input()
count = 0
d = {}
mid = ''
res = ''
for w in word:
    if w in d:
        d[w] += 1
    else:
        d[w] = 1

for key in d.keys():
    if d[key] % 2 != 0:
        mid = key
        count += 1

if count >= 2:
    print("I'm Sorry Hansoo")
else:
    sortedKey = sorted(d)
    for key in sortedKey:
        res += key * (d[key]//2)
    res = res + mid + res[::-1]
    print(res)