import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        recu(N,M,0);
        System.out.println(sb);
    }
    static void recu(int N, int M, int depth){
        // 기저조건
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // 구현
        for(int i = 1; i <= N; i++){
            arr[depth] = i;
            recu(N, M, depth + 1);
        }
    }
}
