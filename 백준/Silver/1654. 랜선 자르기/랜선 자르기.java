import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K,N;
    static long MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            if(MAX < arr[i]){
                MAX = arr[i];
            }
        }
        Arrays.sort(arr);

        System.out.println(upperBound(arr)-1);
    }

    // 찾고자 하는 값보다 1큰 값을 리턴
    private static long upperBound(int[] arr){
        long lo = 0;
        long hi = MAX+1;

        while(lo < hi){
            long mid = (lo+hi) / 2;
            long count = 0;

            for(int i=0; i<arr.length; i++){
                count += arr[i] / mid;
            }

            // 201이면 10개 200이면 11개
            if(count < N){
                hi = mid;
            } else{
                lo = mid +1;
            }
        }
        return lo;
    }
}