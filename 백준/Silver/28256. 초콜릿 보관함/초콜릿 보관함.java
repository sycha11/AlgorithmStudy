import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            map = new char[3][3];
            visited = new boolean[3][3];
            LinkedList<Integer> list = new LinkedList<>();

            for(int i=0; i<3; i++){
                String str = br.readLine();
                for(int j=0; j<3; j++){
                    map[i][j] = str.charAt(j);
                }
            } // map 입력

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(!visited[i][j] && map[i][j] == 'O'){
                        int k = bfs(i,j);
                        list.add(k);
                    }
                }
            } // map 입력

            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int[] answer = new int[c];
            for(int i=0; i<c; i++){
                answer[i] = Integer.parseInt(st.nextToken());
            }

            Collections.sort(list);

//            for(int i=0; i<list.size(); i++){
//                System.out.print(list.get(i) + " ");
//            }
//            System.out.println();



            int result = 1;

            if(list.size() == c){
                if(list.size() != 0){
                    if(list.get(0) == 9){
                        list.set(0,8);
                    }
                }

                for(int i=0; i<list.size(); i++){
                    if(list.get(i) != answer[i]){
                        result = 0;
                        break;
                    }
                }
            } else {
                result = 0;
            }
            System.out.println(result);
        }

    }

    private static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int cnt = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            visited[nowX][nowY] = true;
            cnt+=1;
//            System.out.println(nowX + " " + nowY);

            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3){
                    continue;
                }

                if(visited[nx][ny] || map[nx][ny] == '-' || map[nx][ny] == 'X'){
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] =='O'){
                    q.add(new int[]{nx, ny});
                }

            }
        }

        return cnt;
    }

}
