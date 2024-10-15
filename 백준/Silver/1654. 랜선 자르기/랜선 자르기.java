import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K,N;
    static int[] lan;
 // 시간복잡도 생각하기
 public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        long max = 0;
        for(int i=0; i<K; i++){
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        long start = 0;
        long end = max+1;
        long answer = 0;

        while(start < end){

            long mid = (start + end) / 2;
            int sum = 0; // 잘라내는 갯수의 함 즉 답

            for(int i=0; i<K; i++){
                sum += lan[i] / mid;
            }

//            System.out.println(start + " " + end + " " + sum + " mid : " + mid);

            if(sum >= N){
                start = mid + 1;
            } else { // 필요한 랜선 수 보다 부족하다면 Sum < N
                end = mid;
            }

        }

        System.out.println(start - 1);
    }
}