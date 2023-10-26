import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 끊어서 배열에 담기
        String[] arr1 = new String[str1.length()-1];
        String[] arr2 = new String[str2.length()-1];
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
             arr1[i] = (String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1))).toUpperCase();
                list1.add((String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1))).toUpperCase());
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
             arr2[i] = (String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1))).toUpperCase();
                list2.add((String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1))).toUpperCase());
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        
        Collections.sort(list1);
        Collections.sort(list2);
        
             
        int gyo = 0;
        int hap = 0;
        
        for(String s : list1){
            if(list2.remove(s)){
                gyo++;
            }
            hap++;
        }
        for(String s : list2){
            hap++;
        }
       
        System.out.println(gyo);
        System.out.println(hap-gyo);
        
        if(hap == 0){
            answer = 65536;
        } else{
            double d = (double)gyo/hap;
            answer = (int)(d * 65536);
        }
        return answer;
    }
}

// 둘다 공집합이면 1