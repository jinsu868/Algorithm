import sys
input = sys.stdin.readline

alph = input()
res = 0

table = [['A', 'B', 'C'], ['D', 'E', 'F'], ['G', 'H', 'I'],
        ['J', 'K', 'L'], ['M', 'N', 'O'], ['P', 'Q', 'R', 'S'],
        ['T', 'U', 'V'], ['W', 'X', 'Y', 'Z']]

for s in alph:
    for i in range(len(table)):
        if s in table[i]:
            res += (i + 3)
            break
print(res)