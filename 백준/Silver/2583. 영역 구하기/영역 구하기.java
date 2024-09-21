import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};

    static LinkedList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited =new boolean[N][M];
        answer = new LinkedList<>();

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (!visited[j][k]) {
                        visited[j][k] = true;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for(Integer i : answer){
            System.out.print(i + " ");
        }

    }

    static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{a,b});
        visited[a][b] = true; // 방문체크

        int count = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }

                if(visited[nextX][nextY]){
                    continue;
                }

                count++;
                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true; // 방문체크

            }
        }

        answer.add(count);
    }
}