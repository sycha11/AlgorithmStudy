num = int(input())
c = []
for _ in range(num):
    c.append(list(map(int,input().split())))

dp = [c[0]]+[[0,0,0] for _ in range(num-1)]
for i in range(1,num):
    dp[i][0] = c[i][0]+min(dp[i-1][1],dp[i-1][2])
    dp[i][1] = c[i][1]+min(dp[i-1][0],dp[i-1][2])
    dp[i][2] = c[i][2]+min(dp[i-1][1],dp[i-1][0])

print(min(dp[num-1]))
