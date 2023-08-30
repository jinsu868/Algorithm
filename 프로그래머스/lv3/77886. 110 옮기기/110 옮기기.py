def solution(s):
    res = []
    for e in s:
        st = []
        l = 0
        count = 0
        for cur in e:
            if l >= 2 and st[-1] == '1' and st[-2] == '1' and cur == '0':
                count += 1
                st.pop()
                st.pop()
                l -= 2
            else:
                st.append(cur)
                l += 1

        one_cnt = 0
        for x in st[::-1]:
            if x == '1':
                one_cnt += 1
            else:
                break

        temp = ''.join(st[:l-one_cnt]) + '110' * count + '1' * one_cnt
        res.append(temp)
    return res