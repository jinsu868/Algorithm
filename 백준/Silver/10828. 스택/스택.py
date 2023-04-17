import sys
input = sys.stdin.readline
n = int(input())
st = []

for _ in range(n):
    cmd = input().split()
    if len(cmd) == 2:
        if cmd[0] == "push":
            st.append(int(cmd[1]))
    else:
        if cmd[0] == "top":
            if not st:
                print(-1)
            else:
                print(st[-1])
        elif cmd[0] == "size":
            print(len(st))
        elif cmd[0] == "pop":
            if not st:
                print(-1)
            else:
                print(st.pop())
        elif cmd[0] == "empty":
            if not st:
                print(1)
            else:
                print(0)