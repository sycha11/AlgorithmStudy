N = int(input())
l = list(map(int,input().split()))
stack = []
answer = []
for i in range(N):
    while True:
        if stack:
            if l[stack[-1]] >= l[i]:
                answer.append(stack[-1]+1)
                stack.append(i)
                break
            else:
                stack.pop()
        else:
            answer.append(0)
            stack.append(i)
            break
print(*answer)