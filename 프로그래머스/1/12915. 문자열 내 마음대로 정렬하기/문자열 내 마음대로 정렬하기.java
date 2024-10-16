import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for(int i=0; i<strings.length; i++){
            answer[i] = "";
        }
        
        String[] strArr = new String[strings.length];
        
        for(int i=0; i<strArr.length; i++){
            strArr[i] = "";
        }
        for(int i=0; i<strings.length; i++){
            char b = strings[i].charAt(n);
            strArr[i] += b + strings[i];
        }
        
        Arrays.sort(strArr);
        
        for(int i=0; i<strings.length; i++){
            answer[i] = strArr[i].substring(1, strArr[i].length());
        }
        
        
        return answer;
    }
}