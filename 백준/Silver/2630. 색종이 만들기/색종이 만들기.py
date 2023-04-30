n = int(input())
grid = []
bCount = 0
wCount = 0
for _ in range(n):
    grid.append(list(map(int, input().split())))

def isSame(y, x, size):
    temp = grid[y][x]
    for i in range(y, y + size):
        for j in range(x, x + size):
            if temp != grid[i][j]:
                return False
    if temp == 1:
        return 2
    else:
        return 1

def func(y, x, size):
    global bCount
    global wCount
    if isSame(y, x, size) == 2:
        bCount += 1
    elif isSame(y, x, size) == 1:
        wCount += 1
    else:
        size = size // 2
        func(y, x, size)
        func(y, x + size, size)
        func(y + size, x, size)
        func(y + size, x + size, size)

func(0, 0, n)
        
print(wCount)
print(bCount)
