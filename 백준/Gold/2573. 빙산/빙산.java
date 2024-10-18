import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;
    static int[][] saveMap;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        saveMap = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                saveMap[i][j] = map[i][j];
            }
        }

        int answer = 0;

        while(true){
            if(checkAnswer() >= 2){
                break;
            }
            if(checkAnswer() == 0){
                answer = 0;
                break;
            }
            breakArea();
            answer++;

        }
        System.out.println(answer);
    }

    static void breakArea(){
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < M - 1; j++){
                int cnt = 0;
                if(map[i][j] >= 0){
                    if(map[i-1][j] == 0){
                        cnt++;
                    }
                    if(map[i+1][j] == 0){
                        cnt++;
                    }
                    if(map[i][j-1] == 0){
                        cnt++;
                    }
                    if(map[i][j+1] == 0){
                        cnt++;
                    }
                }
                saveMap[i][j] -= cnt;
                if(saveMap[i][j] < 0){
                    saveMap[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = saveMap[i][j];
            }
        }
    }

    static int checkAnswer(){
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if(map[i][j] > 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
//        System.out.println("cnt " + cnt);
        return cnt;
    }

    static void dfs(int a, int b, boolean[][] visited){
        visited[a][b] = true;

        for(int i=0; i<4; i++){
            int nx = dx[i] + a;
            int ny = dy[i] + b;

            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                continue;
            }
            if(visited[nx][ny]){
                continue;
            }
            if(map[nx][ny] <= 0){
                continue;
            }
            dfs(nx, ny, visited);

        }
    }
}