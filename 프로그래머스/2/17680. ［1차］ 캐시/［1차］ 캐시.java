import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        if(cacheSize==0){
            return cities.length*5;
        }
        for(int i=0; i<cities.length; i++){
           cities[i] = cities[i].toUpperCase();
             if(q.contains(cities[i])){ // 포함되어있으면 +1
                answer++;
                q.remove(cities[i]);                
            } else{ // 포함안되어있으면 +5
                answer+=5;
                if(q.size()==cacheSize){ // 사이즈 꽉차면 삭제
                    q.remove();               
                }
            }
            q.add(cities[i]);
            // System.out.println(answer);
        }
        
        return answer;
    }
}