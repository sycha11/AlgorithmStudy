import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		
	static int n,m,L;
	static int[] huge;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		huge = new int[n+2];
		st = new StringTokenizer(br.readLine());
		huge[0] = 0;
		huge[n] = L;
		for(int i=0; i<n; i++) {
			huge[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(huge);
		
//		System.out.println(Arrays.toString(huge));
		
		int answer = search();
		System.out.println(answer);
	}
	
	static int search() {
		int left = 1;
		int right = L-1;
	
		while(left <= right) {
			int mid = (left+right) / 2; // 400
			int sum = 0;
			for(int i=1; i<n+2; i++) {
				// 현재 휴게소 사이에 mid 기준으로 몇개의 휴게소를 설치할 수 있는가
				sum += (huge[i] - huge[i-1] - 1) / mid;
			}
			if(sum > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
//			System.out.println(right + " " + mid);
		}
		return left;
	}

}