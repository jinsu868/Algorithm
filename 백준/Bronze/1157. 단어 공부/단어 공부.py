word = input()
word = word.upper()
count = [0] * 26
maxValue = 0
dup = 0
ans = 0

for i in range(ord('A'), ord('Z') + 1):
    count[i - ord('A')] = word.count(chr(i))

maxValue = max(count)

for i in range(26):
    if count[i] == maxValue:
        dup += 1
        ans = i
    if dup == 2:
        break
    
if dup == 2:
    print('?')
else:
    print(chr(ans + ord('A')))