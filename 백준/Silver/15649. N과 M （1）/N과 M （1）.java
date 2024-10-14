import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        visited = new boolean[n+1];

        recu(0,0);

    }

    static void recu(int start, int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                recu(start+1, depth+1);
                visited[i] = false;
            }
        }

    }
}