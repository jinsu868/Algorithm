n = int(input())
nums = list(map(int, input().split()))
res = 0
nums.sort()

for i in range(n):
    temp = nums[:i] + nums[i+1:]
    s = 0
    e = len(temp) - 1
    while s < e:
        if temp[s] + temp[e] == nums[i]:
            res += 1
            break
        elif temp[s] + temp[e] > nums[i]:
            e -= 1
        else:
            s += 1
print(res)