def solution(cacheSize, cities):
    cache = []
    l = len(cities)
    res = 0
    size = 0
    
    if cacheSize == 0:
        return 5 * l
    
    for i in range(l):
        x = cities[i].lower()
        if x in cache:
            cache.remove(x)
            cache.append(x)
            res += 1
        else:
            res += 5
            if size == cacheSize:
                cache.pop(0)
                cache.append(x)
            else:
                cache.append(x)
                size += 1
    return res