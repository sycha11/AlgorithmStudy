import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int k = commands[i][2];
            
            int[] arr = new int[b-a+2];
            int index = 0;
            for(int j=a-1; j<b; j++){
                arr[index++] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[k];
        }
        
        return answer;
    }
}