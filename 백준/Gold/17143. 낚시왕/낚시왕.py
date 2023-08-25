R,C,M = map(int,input().split())
shark_list = []
arr = [[0 for _ in range(C)] for _ in range(R)]
for i in range(M):
    r,c,s,d,z = map(int,input().split())
    if d == 1 or d==2:
        if R>4:
            s %=2*(R-1)
    else:
        if C>4:
            s %= 2*(C-1)
    shark_list.append((r-1,c-1,s,d,z))
    arr[r-1][c-1] = (z,i)
    #상어의 크기와 번호 넣기

# for x in range(R):
#     print(arr[x])
# print("")
shark_sum = 0
for i in range(C):
    # 최상단의 상어 포획
    for j in range(R):
        if arr[j][i] != 0:
            shark_sum += arr[j][i][0]
            shark_list[arr[j][i][1]] = 0
            arr[j][i] = 0
            break

    # for x in range(R):
    #     print(arr[x])
    # print("")        
    # 상어 이동
    for k in range(M):
        if shark_list[k] != 0:
            r,c,s,d,z = shark_list[k]
            arr[r][c] = 0
            if d==1 or d==2:
                for _ in range(s):
                    if d==1:
                        if 0<r<=R-1:
                            r -= 1
                        else:
                            d = 2
                            r += 1
                    else:
                        if 0<=r<R-1:
                            r += 1
                        else:
                            d = 1
                            r -= 1
            
            else:
                for _ in range(s):
                    if d==3:
                        if 0<=c<C-1:
                            c += 1
                        else:
                            d = 4
                            c -= 1
                    else:
                        if 0<c<=C-1:
                            c -= 1
                        else:
                            d = 3
                            c += 1
            
            shark_list[k] = (r,c,s,d,z)

    
    for k in range(M):
        if shark_list[k] != 0:
            r,c,s,d,z = shark_list[k]
            
            if arr[r][c] == 0:
                arr[r][c] = (z,k)
            elif arr[r][c] !=0:
                if z>arr[r][c][0]:
                    shark_list[arr[r][c][1]] = 0
                    arr[r][c] = (z,k)
                else:
                    shark_list[k] = 0

    # for x in range(R):
    #     print(arr[x])
    # print("")
            
    # print(shark_list)
    # print("")


print(shark_sum)