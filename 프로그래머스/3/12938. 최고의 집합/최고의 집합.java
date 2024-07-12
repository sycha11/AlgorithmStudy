import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s < n){
            return new int[]{-1};
        }
        int pivot = s / n;
        int na = (s % n);
        
        for(int i=0; i<n; i++){
            answer[i] = pivot;
        }
        
        for(int i=0; i<na; i++){
            answer[i] += 1;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}