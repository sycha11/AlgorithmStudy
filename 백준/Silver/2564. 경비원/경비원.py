w,h = map(int,input().split())
n = int(input())
l = []
for i in range(n):
    x,y = map(int,input().split())
    l.append((x,y))
    
cx,cy = map(int,input().split())

if cx==1:
    sx,sy = cy,h 
elif cx==2:
    sx,sy = cy,0
elif cx==3 :
    sx,sy = 0,h-cy
else:
    sx,sy = w,h-cy

distance = 0
for i in range(n):
    a,b = l[i]
    if a==1:
        x,y = b,h 
    elif a==2:
        x,y = b,0
    elif a==3 :
        x,y = 0,h-b
    else:
        x,y = w,h-b
    
    if sx == 0:
        distance +=x
        if y==0 or y==h or sx==x:
            distance +=abs(y-sy)
        else:
            distance +=min(y+sy,2*h-y-sy)
    elif sx == w:
        distance +=(w-x)
        if y==0 or y==h or sx==x:
            distance +=abs(y-sy)
        else:
            distance +=min(y+sy,2*h-y-sy)
    elif sy ==0:
        distance +=y
        if x==0 or x==w or sy==y:
            distance +=abs(x-sx)
        else:
            distance +=min(x+sx,2*w-x-sx)
    elif sy == h:
        distance +=(h-y)
        if x==0 or x==w or sy ==y:
            distance +=abs(x-sx)
        else:
            distance +=min(x+sx,2*w-x-sx)

print(distance)