a, b, c, d, e, f = map(int, input().split())
x = (e*c - b*f) // (a*e -b*d)
y = (-c*d + a*f) // (a*e - b*d)

print(x, y)
