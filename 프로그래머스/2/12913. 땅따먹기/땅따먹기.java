class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];
        
        // 0행 초기화
        for(int j=0; j<4; j++){
            dp[0][j] = land[0][j]; 
        }
        
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                int max = 0;
                for(int k=0; k<4; k++){
                    // 같은 열이 아닐 때의 최댓값
                    if(j != k){
                        max = Math.max(max, dp[i-1][k]);            
                    }
                }
                dp[i][j] = max + land[i][j];
            }
        }
                
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}