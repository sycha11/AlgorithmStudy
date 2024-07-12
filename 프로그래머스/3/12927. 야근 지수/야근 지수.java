import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        while(n > 0){
            int a = pq.poll();
            pq.add(a-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a >= 0){
                answer += (long)Math.pow(a, 2);
            }
        }
        
        return answer;
    }
}