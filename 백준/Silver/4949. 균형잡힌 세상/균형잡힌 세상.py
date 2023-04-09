while True:
    s = input()
    st = []
    flag = False
    if s == '.':
        break
    
    for x in s:
        if x == '(' or x == '[':
            st.append(x)
        elif x == ')':
            if not st:
                flag = True
                break
            elif st[-1] == '(':
                st.pop()
            else:
                flag = True
                break
        elif x == ']':
            if not st:
                flag = True
                break
            elif st[-1] == '[':
                st.pop()
            else:
                flag = True
                break
    
    if len(st) == 0 and flag == False:
        print("yes")
    else:
        print("no")