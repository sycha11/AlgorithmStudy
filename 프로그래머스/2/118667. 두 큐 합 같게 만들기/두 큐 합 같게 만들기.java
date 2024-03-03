import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long total = 0;
        
        for(int i=0; i<queue1.length; i++){
            total += queue1[i] + queue2[i];
            sum1 += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
       
        // sum1 = qhap(q1);
        // sum2 = qhap(q2);
        System.out.println(sum1);

        int size = (q1.size() + q2.size()) * 2;
        System.out.println(size);
        // int result = size;
            
        int cnt = 0;
        
        // max = Math.max(max1, max2);
        long target = total/2; // 15
        
        // 총 원소의 합이 홀수면 -1
        if(total % 2 != 0) {
            return -1;
        }
        
         while(true){
             if(answer>size){
                 return -1;
             }
            if(sum1 == target){
                break;
            } else if(sum1 > target){
                sum1 -= q1.peek();
                int a = q1.poll();
                q2.add(a);
            } else {
                sum1 += q2.peek();
                int a = q2.poll();
                q1.add(a);
            }

            // sum1 = qhap(q1);
            // sum2 = qhap(q2);

            answer++;
        }
        
        
       
        return answer;
    }
    
    static long qhap(Queue<Integer> q){
        if(q.size() == 0){
            return 0;
        }
        Iterator<Integer> iter =  q.iterator();
        long sum = 0;
        while(iter.hasNext()){
            sum += iter.next();
        }
        
        return sum;
    }
}