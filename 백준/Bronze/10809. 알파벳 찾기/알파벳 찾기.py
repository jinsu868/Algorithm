check = [-1] * 26
s = input()

for i in range(len(s)):
    alphIdx = ord(s[i]) - ord('a')
    if check[alphIdx] == -1:
        check[alphIdx] = i

for x in check:
    print(x, end = ' ')