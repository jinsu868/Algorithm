import sys
input = sys.stdin.readline
def bSearch(arr, n, t):
    s = 0
    e = n-1
    
    while s <= e:
        mid = (s + e) // 2
        if arr[mid] == t:
            return True
        elif arr[mid] > t:
            e = mid-1
        else:
            s = mid+1
    return False

n = int(input())
a = list(map(int, input().split()))
m = int(input())
t = list(map(int, input().split()))

a.sort()

for x in t:
    if bSearch(a, n, x):
        print(1)
    else:
        print(0)