import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        int max1 = 0;
        int max2 = 0;
        int max = 0;
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        
        sum1 = qhap(q1);
        sum2 = qhap(q2);
        // System.out.println(sum1);
        // System.out.println(sum2);

        int size = (q1.size() + q2.size()) * 3;
        int result = size;
            
        int cnt = 0;
        long total = sum1 + sum2;
        
        long target = total/2; // 15
        
        // 총 원소의 합이 홀수거나 가장 큰 원소의 값이 total의 절반보다 크다면 계산 할 수가 없다.
        if(total % 2 != 0) {
            return -1;
        }
        
         while(true){
            if(answer>size){
                 return -1;
             }
            if(target < sum2){ // q2가 더 크다면
                // q2에서 빼서 q1에 넣어줌
                sum2 -= q2.peek();
                int a = q2.poll();
                q1.add(a);
            } else if(target > sum2){ // q2가 작다면
                // q1에서 빼서 q2에 넣어줌
                sum2 += q1.peek();
                int a = q1.poll();
                q2.add(a);
            } else { // 같다면
                // 같다면 끝
                break;
            }

            // sum1 = qhap(q1);
            // sum2 = qhap(q2);
            size--;
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