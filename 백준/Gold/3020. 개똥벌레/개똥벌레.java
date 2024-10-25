import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,H;
    static int[] down;
    static int[] up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[N/2];
        up = new int[N/2];

        for(int i = 0; i < N/2; i++){
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            down[i] = n1;
            up[i] = n2;
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = N;
        int start = 0;
        int end = N/2;
        int cnt = 0;

        for(int i = 1; i <= H; i++){
            int sum = binarySearch(0, N/2, i, down) + binarySearch(0, N/2, H-i+1, up);

            if(min == sum){
                cnt++;
                continue;
            }

            if(min > sum){
                min = sum;
                cnt = 1;
            }
        }
        System.out.println(min + " " + cnt);

    }

    // end = N/2
    // h = i마다 증가하는 높이
    // arr = 크기가 N/2인 석순 종유석 배열
    static int binarySearch(int start, int end, int h, int[] arr){
        while(start < end){
            int mid = (start + end) / 2;

            if(arr[mid] >= h){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr.length - end;
    }

}