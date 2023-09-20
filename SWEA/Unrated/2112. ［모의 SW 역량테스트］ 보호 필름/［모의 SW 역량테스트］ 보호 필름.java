import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int res;
	static int D,W,K; // 두께, 너비, 안전기준
	static int[][] map;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			res = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} 
			
			arr = new int[D];
			for(int i=0; i<D; i++) {
				arr[i] = -1; // 막 초기화
			}
			
			// 현재 몇번째의 막의 정보를 수정하고 있는지, 현재까지 몇번 막의 정보를 수정했는지
			dfs(0, 0);
			
			
			System.out.println("#" + tc + " " + res);
		}
		
	}

	static void dfs(int idx, int cnt) {
		if(cnt > res) { // 최적화
			return;
		}
		
		// 기저조건
		if(idx == D) {
			// 안전하면 cnt와 최종횟수를 비교해서 최소값으로 변경
			if(check()) {
				res = Math.min(res, cnt);
			}
			return;
		}
		
		arr[idx] = -1;
		dfs(idx+1, cnt);
		
		arr[idx] = 0;
		dfs(idx+1, cnt+1);
		
		arr[idx] = 1;
		dfs(idx+1, cnt+1);
		
	}

	private static boolean check() {
		int cnt = 0;
		int a,b;
		for(int j=0; j<W; j++) {
			cnt = 1;
			for(int i=0; i<D-1; i++) {
				a = map[i][j];
				b = map[i+1][j];
				// 막이 변경 되었으면 변경된 값을 확인하기
				if(arr[i] != -1) {
					a = arr[i];
				}
				if(arr[i+1] != -1) {
					b = arr[i+1];
				}
				
				// 같냐 비교
				if(a == b) {
					cnt++;
					if(cnt >= K) {
						break;
					}
				} else {
					cnt = 1;
				}
			}
			if(cnt < K) {
				return false;
			}
		}
		return true;
	}
	
}
