import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] c = new int[num][3];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = scanner.nextInt();
            }
        }

        int[][] dp = new int[num][3];
        for (int i = 0; i < num; i++) {
            dp[i][0] = c[i][0] + ((i > 0) ? Math.min(dp[i-1][1], dp[i-1][2]) : 0);
            dp[i][1] = c[i][1] + ((i > 0) ? Math.min(dp[i-1][0], dp[i-1][2]) : 0);
            dp[i][2] = c[i][2] + ((i > 0) ? Math.min(dp[i-1][1], dp[i-1][0]) : 0);
        }

        int result = Math.min(dp[num-1][0], Math.min(dp[num-1][1], dp[num-1][2]));
        System.out.println(result);
    }
}