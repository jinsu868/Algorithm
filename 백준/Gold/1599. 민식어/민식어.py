import functools
#a b k d e g h i l m n ng o p r s t u w y
d = {'a':1, 'b':2, 'k':3, 'd':4, 'e':5, 'g':6, 'h':7, 'i':8, 'l':9, 'm':10, 'n':11, 'x':12,
     'o':13, 'p':14, 'r':15, 's':16, 't':17, 'u':18, 'w':19, 'y':20}

n = int(input())
words = []

def comparator(a,b):
    lenA = len(a)
    lenB = len(b)
    for i in range(min(lenA, lenB)):
        if d[a[i]] == d[b[i]]:
            continue
        elif d[a[i]] > d[b[i]]:
            return 1
        else:
            return -1
    if lenA == lenB:
        return 0
    elif lenA > lenB:
        return 1
    else:
        return -1

for _ in range(n):
    s = input().replace('ng', 'x')
    words.append(s)
words = sorted(words, key=functools.cmp_to_key(comparator))
for word in words:
    print(word.replace('x', 'ng'))