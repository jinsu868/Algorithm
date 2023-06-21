def solution(word):
    words = "AEIOU"
    wordList = []
    
    def sol(cnt, wd):
        if cnt == 5:
            return
        for w in words:
            wordList.append(wd + w)
            sol(cnt+1, wd + w)
    
    sol(0, "")
    
    return wordList.index(word)+1