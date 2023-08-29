d = [(1,0),(0,1),(-1,0),(0,-1)]
answer_list = []
M,N,K = map(int,input().split())
l = [[0 for _ in range(N)] for _ in range(M)]
for _ in range(K):
    x1,y1,x2,y2 = map(int,input().split())
    for i in range(x1,x2):
        for j in range(y1,y2):
            l[j][i] = 1

for j in range(M):
    for i in range(N):
        if l[j][i] == 0:
            stack = []
            stack.append((i,j))
            l[j][i] = 1
            cnt = 0
            while stack:
                x,y = stack.pop()
                cnt +=1
                for i in range(4):
                    dx,dy = d[i]
                    mx = x+dx
                    my = y+dy
                    if 0<=mx<N and 0<=my<M:
                        if l[my][mx] == 0:
                            l[my][mx] = 1 
                            stack.append((mx,my))
            
            answer_list.append(cnt)

answer_list.sort()
print(len(answer_list))
print(*answer_list)