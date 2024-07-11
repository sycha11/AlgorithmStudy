import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        Stack<Character> st = new Stack<>();
        
        a:for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(c);
            } else if(c == ')'){
                if(!st.isEmpty()){
                    st.pop();
                } else{
                    answer = false;
                    break a;
                }
            }
            
        }
        
        if(!st.isEmpty()){
            answer = false;
        }
        
        return answer;
    }
}