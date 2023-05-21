def solution(s):
    l = len(s)
    res = 0
    
    for i in range(0, l):
        flag = True
        st = []
        idx = i
        cnt = 0
        
        while cnt != l:
            if s[idx] == '(':
                st.append('(')
                idx = (idx + 1) % l
                cnt += 1
            elif s[idx] == '[':
                st.append("[")
                idx = (idx + 1) % l
                cnt += 1
            elif s[idx] == '{':
                st.append('{')
                idx = (idx + 1) % l
                cnt += 1
            elif s[idx] == ')':
                if len(st) == 0 or st[-1] != '(':
                    flag = False
                    break
                else:
                    st.pop()
                    idx = (idx + 1) % l
                    cnt += 1
            elif s[idx] == ']':
                if len(st) == 0 or st[-1] != '[':
                    flag = False
                    break
                else:
                    st.pop()
                    idx = (idx + 1) % l
                    cnt += 1
            elif s[idx] == '}':
                if len(st) == 0 or st[-1] != '{':
                    flag = False
                    break
                else:
                    st.pop()
                    idx = (idx + 1) % l
                    cnt += 1
        
        if len(st) != 0:
            flag = False
            
        if flag == True:
            res += 1
    return res
                