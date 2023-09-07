# l = [[[i+50*j,0] for i in range(50)] for j in range(50)]
l = [[[i+50*j,0] for i in range(50)] for j in range(50)]
group = 10000
def UPDATE(r,c,value):
    k = l[r][c][0]
    for i in range(50):
        for j in range(50):
            if l[i][j][0] == k:
                l[i][j][1] = value

def UPDATE_VALUE(value1, value2):
    for i in range(50):
        for j in range(50):
            if l[i][j][1] == value1:
                l[i][j][1] = value2

def MERGE(r1,c1,r2,c2):
    l1,v1 = l[r1][c1]
    l2,v2 = l[r2][c2]
    if l[r1][c1][1] != 0:
        for i in range(50):
            for j in range(50):
                if l[i][j][0] == l1 or l[i][j][0] == l2:
                    l[i][j][0] = group 
                    l[i][j][1] = l[r1][c1][1]
        l[r2][c2][1] = v1
    elif l[r2][c2][1] != 0:
        for i in range(50):
            for j in range(50):
                if l[i][j][0] == l1 or l[i][j][0] == l2:
                    l[i][j][0] = group 
                    l[i][j][1] = l[r2][c2][1]
        l[r1][c1][1] = v2
    else:
        for i in range(50):
            for j in range(50):
                if l[i][j][0] == l1 or l[i][j][0] == l2:
                    l[i][j][0] = group
    
    l[r1][c1][0] = group
    l[r2][c2][0] = group


def UNMERGE(r,c):
    k,v = l[r][c]
    for i in range(50):
        for j in range(50):
            if l[i][j][0] == k:
                l[i][j][0] = i*50+j
                l[i][j][1] = 0
    
    l[r][c][1] = v

def PRINT(r,c):
    if l[r][c][1] != 0:
        return l[r][c][1]
    else:
        return "EMPTY"

def solution(commands):
    global group
    answer = []
    for i in commands:
        m = list(i.split())
        if m[0] == "UPDATE":
            if len(m) == 3:
                UPDATE_VALUE(m[1], m[2])  
            else:
                UPDATE(int(m[1])-1,int(m[2])-1,m[3])
        elif m[0] == "MERGE":
            r1,c1,r2,c2 = map(int,m[1:])
            MERGE(r1-1,c1-1,r2-1,c2-1)
        elif m[0] == "UNMERGE":
            r,c = map(int,m[1:])
            UNMERGE(r-1,c-1)
        elif m[0] == "PRINT":
            x,y = map(int,m[1:])
            answer.append(PRINT(x-1,y-1))

        for i in range(5):
            for j in range(5):
                print(l[i][j],end='')
            
            print(" ")
        print(" ")
        group +=1
    return answer
