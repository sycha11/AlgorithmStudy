import java.util.Scanner;

public class Main {

    static int n,m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n  = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n];

        combi(0,0);
    }
    static void combi(int start, int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]) {
                arr[cnt] = i + 1;
                visited[i] = true;
                combi(start + 1, cnt + 1);
                visited[i] = false;
            }

        }
    }
}