n = input()
s = 0

if '0' not in n:
    print(-1)
else:
    for x in n:
        s += int(x)
    if s % 3 != 0:
        print(-1)
    else:
        n = sorted(n, reverse=True)
        print(''.join(n))