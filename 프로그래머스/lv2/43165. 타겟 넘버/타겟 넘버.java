class Solution {
    static boolean[] visited;
    static boolean[] check;
    static int cnt = 0;
    static int n;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;
        visited = new boolean[n];
        check = new boolean[2];
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public static void dfs(int[] numbers, int target, int start, int sum){
        
        if(start == numbers.length){
            if(sum == target){
                cnt++;
            }

            return;
        }
        
        dfs(numbers, target, start+1, sum+numbers[start]);
        dfs(numbers, target, start+1, sum-numbers[start]);
    }
}