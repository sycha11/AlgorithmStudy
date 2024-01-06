import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> sub = new Stack<>();
        
        int box = 1;
        
        for(int i=0; i<order.length; i++){
            while(box <= order.length){
                if(box == order[i]){
                    break;
                } else if (!sub.isEmpty() && sub.peek() == order[i]) {
                    break;
                }
                else {
                    sub.push(box);
                    box++;
                }
            }

            if(box == order[i]){
                box++;
                answer++;
            } else if (!sub.isEmpty() && sub.peek() == order[i]) {
                sub.pop();
                answer++;
            } else{
                break;
            }
        }
        
        return answer;
    }
}