
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class FenwickTree{
		long[] tree;
		int n;
		public FenwickTree(int n) {
			this.n = n;
			this.tree = new long[n+1];
		}
		
		// 계산 메소드
		public long sum(int pos) {
			long sum = 0;
			int tmp = pos;
			while(tmp > 0) {
				sum += this.tree[tmp]; // 트리에 저장된 값 더해줌
				tmp -= (tmp & -tmp); // LSB를 찾아서 빼줌
			}
			return sum;
		}
		
		// 위치를 업데이트 해줌
		public void update(int pos, long val) {
			int tmp = pos;
			while(tmp <= this.n) {
				this.tree[tmp] += val;
				tmp += (tmp & -tmp);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N+1];
		FenwickTree fw = new FenwickTree(N);
		
		for(int i=1; i<=N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			fw.update(i, arr[i]);
		}
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			if(w == 1) {
				int pos = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());
				fw.update(pos, val - arr[pos]);
				arr[pos] = val;
			} else if(w == 2) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long sum = fw.sum(end) - fw.sum(start-1);
				System.out.println(sum);
			}
		}
		
	}

}
