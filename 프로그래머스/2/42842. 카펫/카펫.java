class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int sum = (brown+4)/2;
        for(int i=1; i<=brown; i++){
            for(int j=1; j<=brown; j++){
                if(i+j == sum){
                    if(((i-2)*(j-2)) == yellow){
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }
        return answer;
    }
}