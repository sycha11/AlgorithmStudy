import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        // 돌려
        for(int i=0; i<s.length(); i++){
            String newS = s.substring(i,s.length()) + s.substring(0,i);
            
            // 올바른 문자열인지 판별
            Stack<Character> st = new Stack<>();
            for(int j=0; j<s.length(); j++){
                char c = newS.charAt(j);
                
                if(st.isEmpty()){ // 비어있다면 스택에 추가
                    st.push(c);
                } else if(c == ']' && st.peek() == '['){ // 맞으면 pop
                    st.pop();
                } else if(c == '}' && st.peek() == '{'){ // 맞으면 pop
                    st.pop();
                } else if(c == ')' && st.peek() == '('){ // 맞으면 pop
                    st.pop();
                } else{
                    st.push(c);
                }
            }
            // System.out.println(newS);
            if(st.isEmpty()){
                answer++;
            }
            
        }
        

        return answer;
    }
}