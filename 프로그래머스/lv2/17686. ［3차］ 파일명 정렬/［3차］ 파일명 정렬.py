def solution(files):
    store = []
    res = []
    for file in files:
        nPtr = 0
        tPtr = 0
        l = len(file)
        for i in range(l):
            if file[i].isdigit():
                nPtr = i
                break
        for i in range(nPtr+1, l):
            if not file[i].isdigit():
                tPtr = i
                break
    
        head = file[0:nPtr]
        if tPtr == 0:
            tail = ''
            number = file[nPtr:]
        else:
            number = file[nPtr:tPtr]
            tail = file[tPtr:]
        
        
        store.append([head, number, tail])
    
    store.sort(key=lambda x:(x[0].lower(), int(x[1])))
    for x in store:
        res.append(x[0]+x[1]+x[2])
    return res
        
                
    
    