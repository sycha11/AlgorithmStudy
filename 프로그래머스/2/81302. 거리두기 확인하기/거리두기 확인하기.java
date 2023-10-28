import java.util.*;
class Solution {
    
    static int n = 5;
    static char[][] map;
    static ArrayList<Node> list;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int k;
    
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int T = places.length;
        
        for(int tc=0; tc<T; tc++){
            map = new char[n][n];
            list = new ArrayList<>();            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = places[tc][i].charAt(j);
                    if(map[i][j] == 'P'){ // 사람들 리스트에 넣기
                        list.add(new Node(i,j));
                    }
                }
            } // 입력 끝
            k=1;
            // 맨해튼 거리에 있으면 0 없으면 1
            for(int i=0; i<list.size(); i++){
                visited = new boolean[n][n];
                dfs(list.get(i).x, list.get(i).y, 0);
            }
             
            answer[tc] = k;
        }
        System.out.println(manha(0,0,1,1));
        return answer;
    }
    
    static void dfs(int a, int b, int depth){
        if(depth == 2){
            return;
        }
        visited[a][b] = true;
        for(int i=0; i<4; i++){
            int nx = a + dx[i];
            int ny = b + dy[i];
            if(nx<0 || ny<0 || nx>=5 || ny>=5){
                continue;
            }
            if(map[nx][ny] == 'X'){
                continue;
            }
            if(visited[nx][ny]){
                continue;
            }
            if(map[nx][ny] == 'P'){
                k=0;
            }
            dfs(nx,ny, depth+1);
        }
    }
    
    // x1-x2 + y1-y2
    static int manha(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    
}