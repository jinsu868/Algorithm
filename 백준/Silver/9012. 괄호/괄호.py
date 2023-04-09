import sys
input = sys.stdin.readline
n = int(input())

for _ in range(n):
    p = input()
    st = []
    flag = True
    for x in p:
        if x == '(':
            st.append('(')
        elif x == ')':
            if not st:
                flag = False
                break
            else:
                st.pop()
    if st:
        flag = False
    if flag == True:
        print("YES")
    else:
        print("NO")
        