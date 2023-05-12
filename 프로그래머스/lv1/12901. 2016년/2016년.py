def solution(a, b):
    monthDay = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    d = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"] #day 1 -> FRI
    day = 0    
    for i in range(a-1):
        day += monthDay[i]
    day += b
    day %= 7
    res = d[day]
    return res
