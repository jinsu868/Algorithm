t = int(input())

for _ in range(t):
    n = int(input())
    phoneNumbers = []
    for _ in range(n):
        phoneNumbers.append(input())
    phoneNumbers.sort()
    flag = True
    for i in range(len(phoneNumbers)-1):
        numberLen = len(phoneNumbers[i])
        if phoneNumbers[i] == phoneNumbers[i+1][:numberLen]:
            flag = False
            break
    if flag == True:
        print("YES")
    else:
        print("NO")