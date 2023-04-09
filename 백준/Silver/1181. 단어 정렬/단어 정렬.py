n = int(input())
words = set()

for _ in range(n):
    words.add(input())

words = list(words)
res = []

for s in words:
    res.append([len(s), s])
res.sort(key = lambda x: (x[0], x[1]))

for x in res:
    print(x[1])