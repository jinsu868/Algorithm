def solution(s):
    st = []
    st.append(s[0])
    l = len(s)
    stp = 1
    
    for i in range(1, l):
        if stp == 0:
            st.append(s[i])
            stp += 1
        elif st[-1] == s[i]:
            st.pop()
            stp -= 1
        else:
            stp += 1
            st.append(s[i])
    if stp == 0:
        return 1   
    else:
        return 0
            
    
    