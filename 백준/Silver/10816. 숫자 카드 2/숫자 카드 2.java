import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sang = new int[N];
        for(int i=0; i<N; i++){
            sang[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sang);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(sang, key) - lowerBound(sang, key)).append(' ');
        }
        System.out.println(sb);

    }

    private static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo+hi) / 2;
            if(arr[mid] >= key){
                hi = mid;
            } else{
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while(lo < hi){
            int mid = (lo+hi) / 2;
            if(arr[mid] > key){
                hi = mid;
            } else{
                lo = mid +1;
            }
        }
        return lo;
    }
}