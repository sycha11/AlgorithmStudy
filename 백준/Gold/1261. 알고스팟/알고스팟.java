import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int x,y,depth;
        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o){
            return depth - o.depth;
        }
    }

    static int N,M;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int a, int b){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a,b,0));
        boolean[][] visited = new boolean[N][M];
        visited[a][b] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int nowX = node.x;
            int nowY = node.y;
            int depth = node.depth;


            if(nowX == N-1 && nowY == M-1){
                return depth;
            }

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }

                if(!visited[nextX][nextY] && map[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    pq.add(new Node(nextX, nextY, depth));
                }

                if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    pq.add(new Node(nextX, nextY, depth+1));
                }
            }
        }
        return 0;

    }
}