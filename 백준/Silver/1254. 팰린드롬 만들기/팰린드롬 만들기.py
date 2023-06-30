import sys
input = sys.stdin.readline
word = input().rstrip()
wordLen = len(word)

for i in range(wordLen):
    if word[i:] == word[i:][::-1]:
        print(wordLen + i)
        break