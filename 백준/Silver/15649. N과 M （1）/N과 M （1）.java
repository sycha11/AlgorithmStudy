import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        recu(N,M,0);
    }

    static void recu(int N, int M, int depth){
        // 기저조건
        if(depth == M){
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 구현문
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                recu(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
