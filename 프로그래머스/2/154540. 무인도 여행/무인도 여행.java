import java.util.*;
class Solution {
    
    static int n;
    static int m;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int sum;
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[n][m];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                } else{
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                System.out.print(map[i][j]);
            }
             System.out.println();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false && map[i][j] != 0){
                    sum = 0;
                    dfs(i,j);
                    if(sum != 0){
                        list.add(sum);
                    }
                }
            }
        }
         
        
        if(list.size() == 0){
            list.add(-1);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
         for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static void dfs(int x, int y){
        visited[x][y] = true;
        sum += map[x][y];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                continue;
            }
            if(visited[nx][ny]){
                continue;
            }
            if(map[nx][ny] == 0){
                continue;
            }
            
            dfs(nx,ny);
        }
    } 
    
}