class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end = 100000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0;
            for(int i=0; i<diffs.length; i++){
                // 해결한 퍼즐
                if(diffs[i] - mid <= 0){ 
                    sum += times[i];
                } else{
                    sum += ((times[i-1] + times[i]) * (diffs[i] - mid)) + times[i]; 
                }
                if(sum > limit){
                    break;
                }
            }
            // System.out.println(sum + " " + mid);
            if(sum > limit){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            answer = start;
        }
        
        return answer;
    }
}