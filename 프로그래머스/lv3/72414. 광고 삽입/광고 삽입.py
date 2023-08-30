def int_to_str(t):
    h = t // 3600
    h = '0' + str(h) if h < 10 else str(h)
    t = t % 3600
    m = t // 60
    m = '0' + str(m) if m < 10 else str(m)
    t = t % 60
    s = '0' + str(t) if t < 10 else str(t)
    return h + ':' + m + ':' + s

def str_to_int(p):
    h, m, s = p.split(':')
    return int(h)*60*60+int(m)*60+int(s)

def solution(play_time, adv_time, logs):
    p = str_to_int(play_time)
    a = str_to_int(adv_time)
    see = [0 for _ in range(p+1)]
    for l in logs:                           
        start, end = l.split('-')
        start = str_to_int(start)
        end = str_to_int(end)
        see[start] += 1
        see[end] -= 1
        
    
    for i in range(1, len(see)):       
        see[i] = see[i] + see[i - 1]

    for i in range(1, len(see)):       
        see[i] = see[i] + see[i - 1]       

    most_view = 0                          
    max_time = 0                          
    for i in range(a - 1, p):
        if i >= a:
            if most_view < see[i] - see[i - a]:
                most_view = see[i] - see[i - a]
                max_time = i - a + 1
        else:
            if most_view < see[i]:
                most_view = see[i]
                max_time = i - a + 1
    
    return int_to_str(max_time)