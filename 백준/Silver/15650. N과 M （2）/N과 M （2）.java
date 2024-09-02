import java.util.Scanner;

public class Main {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        combi(1,0);

    }

    static void combi(int start, int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<=n; i++){
                arr[cnt] = i;
                combi(i+1, cnt+1);
        }
    }
}