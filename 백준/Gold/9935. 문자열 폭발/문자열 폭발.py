
word = input()
explo = input()
l = len(explo)
st = []

for i in range(len(word)):
    st.append(word[i])
    if st[-1] == explo[-1] and ''.join(st[-l:]) == explo:
        del st[-l:]
        
res = ''.join(st)
        
if res == '':
    print("FRULA")
else:
    print(res)