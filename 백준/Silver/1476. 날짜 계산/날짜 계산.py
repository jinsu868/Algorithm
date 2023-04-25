e, s, m = map(int, input().split())
a, b, c = 1, 1, 1
y = 1

while True:
    a = y % 15
    b = y % 28
    c = y % 19
    if a == 0:
        a = 15
    if b == 0:
        b = 28
    if c == 0:
        c = 19
    if a == e and s == b and m == c:
        print(y)
        break
    y += 1