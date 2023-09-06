import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        char alpha = 'A';
        int idx = 27;
        
        for(int i=0; i<26; i++){
            map.put(String.valueOf((char)(alpha+i)), i+1);
        }
        
        
        for(int i=0; i<msg.length(); i++){
            int index = 1;
            // 문자가 이미 포함 되어 있고 길이가 문자열길이를 넘지 않을때 긴 문자열로 만들어 주기
            while(i+index <= msg.length() && map.containsKey(msg.substring(i, i+index))){
                index++;
            }
            if(i+index > msg.length()){ // A AO
                ans.add(map.get(msg.substring(i))); // 마지막 단어 넣어주기
                break;
            }
            ans.add(map.get(msg.substring(i, i+index-1))); // KA이면 ans에 K넣어주기
            map.put(msg.substring(i, i+index), idx++); // map KA 등록
            
            if(index > 1){
                i = i + index - 2;
            }
        }
        
        return ans;
    }
}