d = {}
d['A+'] = 4.5
d['A0'] = 4.0
d['B+'] = 3.5
d['B0'] = 3.0
d['C+'] = 2.5
d['C0'] = 2.0
d['D+'] = 1.5
d['D0'] = 1.0
d['F'] = 0.0


res = 0
tc = 0
for _ in range(20):
    name, c, s = input().split()
    c = float(c)
    if s == 'P':
        continue
    tc += c
    res += c * d[s]
print('%.6f' % (res / tc))