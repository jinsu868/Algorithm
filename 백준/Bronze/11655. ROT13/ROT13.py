import sys
input = sys.stdin.readline
input_data = input().rstrip()
for x in input_data:
    if x.isdigit() or x == ' ':
        print(x, end = '')
    else:
        if 'a' <= x <= 'z':
            temp = ord(x) + 13
            if temp > ord('z'):
                print(chr(temp - ord('z') + ord('a')-1), end = '')
            else:
                print(chr(temp), end = '')
        else:
            temp = ord(x) + 13
            if temp > ord('Z'):
                print(chr(temp - ord('Z') + ord('A')-1), end = '')
            else:
                print(chr(temp), end = '')