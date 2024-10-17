import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[100+1][100+1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            for(int j = startX; j < startX + 10; j++) {
                for (int k = startY; k < startY + 10; k++) {
                    if (paper[j][k] == 0) {
                        paper[j][k] = 1;
                    }
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(paper[i][j] == 1){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}