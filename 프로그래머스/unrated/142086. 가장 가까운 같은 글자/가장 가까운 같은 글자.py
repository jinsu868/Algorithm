def solution(s):
    answer = []
    for i in range(len(s)):
        flag = False
        for j in reversed(range(i)):
            if s[j] == s[i]:
                flag = True
                answer.append(i-j)
                break
        if flag == False:
            answer.append(-1)

    return answer