import heapq
def solution(scoville, K):
    q = []
    res = 0
    for x in scoville:
        heapq.heappush(q, x)
        
    while q[0] < K:
        res += 1
        if len(q) == 1:
            return -1
        a = heapq.heappop(q)
        b = heapq.heappop(q)
        sc = a + b*2
        heapq.heappush(q, sc)
    return res
    