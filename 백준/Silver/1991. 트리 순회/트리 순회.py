import sys
input = sys.stdin.readline

t = {}
n = int(input())

def inorder(p):
    if p != '.':
        inorder(t[p][0])
        print(p, end = '')
        inorder(t[p][1])

def preorder(p):
    if p != '.':
        print(p, end = '')
        preorder(t[p][0])
        preorder(t[p][1])

def postorder(p):
    if p != '.':
        postorder(t[p][0])
        postorder(t[p][1])
        print(p, end = '')


for _ in range(n):
    p, l, r = input().split()
    t[p] = l, r

preorder('A')
print()
inorder('A')
print()
postorder('A')
