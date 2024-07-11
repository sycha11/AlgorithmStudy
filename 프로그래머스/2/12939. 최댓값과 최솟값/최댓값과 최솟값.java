class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        int[] num = new int[str.length];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<str.length; i++){
            int a = Integer.parseInt(str[i]);
            
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        
        answer += String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}