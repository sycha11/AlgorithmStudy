
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()) + 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=1; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(s == 1) { // 남자라면
				for(int j=idx; j<N; j+=idx) {
					arr[j] ^= 1;
				}
				
			} else { // 여자라면
				int left = idx - 1;
				int right = idx + 1;
				
				while(true) {
					if(left < 1 || right >= N) break; // 범위 벗어나면 탈출
					if(arr[left] != arr[right]) break; // 서로 다르면 탈출
					left--; right++;
				}
				left++; right--;
				while(left <= right) {
					arr[left] ^= 1;
					left++;
				}
			}
		}
		for(int i=1; i<N; i++) {
			System.out.print(arr[i] + " ");
			if(i%20 == 0) System.out.println();
		}
		
	}

}
